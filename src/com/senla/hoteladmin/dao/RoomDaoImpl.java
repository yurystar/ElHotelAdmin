package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.Room;
import com.senla.hoteladmin.entity.RoomStatus;
import com.senla.hoteladmin.entity.RoomType;
import com.senla.hoteladmin.util.DbConnect;
import com.senla.hoteladmin.util.IDbConnect;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomDaoImpl implements IRoomRepo {
    private IDbConnect dbConnect;

    public RoomDaoImpl(IDbConnect dbConnect) {
        this.dbConnect = dbConnect;
    }

    @Override
    public Room getRoom(Integer roomNum) throws SQLException {
        String sql = "SELECT roomNumber, roomType, roomPlaces, roomPrice, roomStatus " +
                "FROM Room WHERE roomNumber=?";

        Room room = new Room();
        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, roomNum);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                room.setRoomNumber(resultSet.getInt("roomNumber"));
                room.setRoomType(RoomType.valueOf(resultSet.getString("roomType")));
                room.setRoomPlaces(resultSet.getInt("roomPlaces"));
                room.setRoomPrice(resultSet.getInt("roomPrice"));
                room.setRoomStatus(RoomStatus.valueOf(resultSet.getString("roomStatus")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    @Override
    public List<Room> getAllRooms(String sql) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        if (sql == null) {
            sql = "SELECT roomNumber, roomType, roomPlaces, roomPrice, roomStatus FROM Room";
        }
        try (Connection connection = dbConnect.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Room room = new Room();
                room.setRoomNumber(resultSet.getInt("roomNumber"));
                room.setRoomType(RoomType.valueOf(resultSet.getString("roomType")));
                room.setRoomPlaces(resultSet.getInt("roomPlaces"));
                room.setRoomPrice(resultSet.getInt("roomPrice"));
                room.setRoomStatus(RoomStatus.valueOf(resultSet.getString("roomStatus")));

                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public void saveRoom(Room room) throws SQLException {
        String sql = "INSERT INTO Room (roomNumber, roomType, roomPlaces, roomPrice, roomStatus) " +
                "VALUES(?, ?, ?, ?, ?)";

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, room.getRoomNumber());
            preparedStatement.setString(2, room.getRoomType().toString());
            preparedStatement.setInt(3, room.getRoomPlaces());
            preparedStatement.setInt(4, room.getRoomPrice());
            preparedStatement.setString(5, room.getRoomStatus().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoom(Room room) throws SQLException {
        String sql = "UPDATE Room SET roomType=?, roomPlaces=?, roomPrice=?, " +
                "roomStatus=? WHERE roomNumber=?";

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, room.getRoomType().toString());
            preparedStatement.setInt(2, room.getRoomPlaces());
            preparedStatement.setInt(3, room.getRoomPrice());
            preparedStatement.setString(4, room.getRoomStatus().toString());
            preparedStatement.setInt(5, room.getRoomNumber());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoom(Room room) throws SQLException {
        String sql = "DELETE FROM Room WHERE roomNumber=?";

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, room.getRoomNumber());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String createRoomSqlStr(String columnName) {
        return "SELECT roomNumber, roomType, roomPlaces, roomPrice, roomStatus FROM Room " +
                "ORDER BY " + columnName;
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomNumber() throws SQLException {
        return getAllRooms(createRoomSqlStr("roomNumber"));
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomPlaces() throws SQLException {
        return getAllRooms(createRoomSqlStr("roomPlaces"));
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomPrice() throws SQLException {
        return getAllRooms(createRoomSqlStr("roomPrice"));
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomType() throws SQLException {
        return getAllRooms(createRoomSqlStr("roomType"));
    }

    @Override
    public String createEmptyRoomSqlStr(String columnName) {
        return "SELECT roomNumber, roomType, roomPlaces, roomPrice, roomStatus FROM Room " +
                "WHERE roomStatus = \"EMPTY\" ORDER BY " + columnName;
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomNumber() throws SQLException {
        return getAllRooms(createEmptyRoomSqlStr("roomNumber"));
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomPlaces() throws SQLException {
        return getAllRooms(createEmptyRoomSqlStr("roomPlaces"));
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomPrice() throws SQLException {
        return getAllRooms(createEmptyRoomSqlStr("roomPrice"));
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomType() throws SQLException {
        return getAllRooms(createEmptyRoomSqlStr("roomType"));
    }

    @Override
    public List<Room> getBusyRoomListOnDate(LocalDate date) throws SQLException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String searchDate = dateTimeFormatter.format(date);
        return getAllRooms("select b.roomNumber, b.roomType, b.roomPlaces, b.roomPrice, b.roomStatus \n" +
                "from BookingOrder as a left join Room as b on a.orderedRoom = b.roomNumber \n" +
                "where DATE (a.orderCheckInDate) <= '" + searchDate +
                "' and DATE (a.orderCheckOutDate) > '" + searchDate + "'");
    }

    @Override
    public List<Room> getEmptyRoomListOnDate(LocalDate date) throws SQLException {
        List<Room> EmptyHotelRoomsListOnDate = getHotelRoomsSortedByRoomNumber();
        EmptyHotelRoomsListOnDate.removeAll(getBusyRoomListOnDate(date));
        return EmptyHotelRoomsListOnDate;
    }

    @Override
    public Integer getNumberEmptyHotelRooms() throws SQLException {
        String sql = "SELECT COUNT(roomNumber) as totalCount FROM Room where roomStatus = ?";

        Integer count = null;
        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, "EMPTY");

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = (resultSet.getInt("totalCount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void setRoomChekInStatus(Integer roomNumber) throws SQLException {
        Room room = getRoom(roomNumber);
        if (room != null) {
            room.setRoomStatus(RoomStatus.BUSY);
        }
        updateRoom(room);
    }

    @Override
    public void setRoomEmptyStatus(Integer roomNumber) throws SQLException {
        Room room = getRoom(roomNumber);
        if (room != null) {
            room.setRoomStatus(RoomStatus.EMPTY);
        }
        updateRoom(room);
    }

    @Override
    public void setRoomStatusOnRepair(Integer roomNumber) throws SQLException {
        Room room = getRoom(roomNumber);
        if (room != null) {
            room.setRoomStatus(RoomStatus.ON_REPAIR);
        }
        updateRoom(room);
    }

    @Override
    public void setRoomNewPrice(Integer roomNumber, Integer newPrice) throws SQLException {
        Room room = getRoom(roomNumber);
        if (room != null) {
            room.setRoomPrice(newPrice);
        }
        updateRoom(room);
    }
}
