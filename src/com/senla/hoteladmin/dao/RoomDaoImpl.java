package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.Room;
import com.senla.hoteladmin.entity.RoomStatus;
import com.senla.hoteladmin.entity.RoomType;
import com.senla.hoteladmin.util.DbConnect;
import com.senla.hoteladmin.util.IDbConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomDaoImpl implements IRoomRepo {
    private IDbConnect dbConnect;

    public RoomDaoImpl(IDbConnect dbConnect) {
        this.dbConnect = dbConnect;
    }

    @Override
    public Optional<Room> getRoom(Integer roomNum) throws SQLException {
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
        return Optional.ofNullable(room);
    }

    @Override
    public List<Room> getAllRooms() throws SQLException {
        List<Room> rooms = new ArrayList<>();

        String sql = "SELECT roomNumber, roomType, roomPlaces, roomPrice, roomStatus FROM Room";

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
}

//    @Override
//    public List<Room> getHotelRoomsSortedByRoomPlaces() {
//        return rooms.stream()
//                .sorted(Comparator.comparingInt(Room::getRoomPlaces))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Room> getHotelRoomsSortedByRoomPrice() {
//        return rooms.stream()
//                .sorted(Comparator.comparingInt(Room::getRoomPrice))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Room> getHotelRoomsSortedByRoomType() {
//        return rooms.stream()
//                .sorted(Comparator.comparing(Room::getRoomType))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Room> getEmptyHotelRoomsSortedByRoomPlaces() {
//        return rooms.stream()
//                .filter(room -> room.getRoomStatus().equals(RoomStatus.EMPTY))
//                .sorted(Comparator.comparingInt(Room::getRoomPlaces))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Room> getEmptyHotelRoomsSortedByRoomPrice() {
//        return rooms.stream()
//                .filter(room -> room.getRoomStatus().equals(RoomStatus.EMPTY))
//                .sorted(Comparator.comparingInt(Room::getRoomPrice))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Room> getEmptyHotelRoomsSortedByRoomType() {
//        return rooms.stream()
//                .filter(room -> room.getRoomStatus().equals(RoomStatus.EMPTY))
//                .sorted(Comparator.comparing(Room::getRoomType))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public long getNumberEmptyHotelRooms() {
//        return rooms.stream()
//                .filter(room -> room.getRoomStatus().equals(RoomStatus.EMPTY))
//                .count();
//    }
//
//    @Override
//    public void setNewPriceRoom(Integer roomNumber, Integer priceRoom) {
//        for (Room room : rooms) {
//            if (room.getRoomNumber().equals(roomNumber)) {
//                room.setRoomPrice(priceRoom);
//            }
//        }
//    }
//
//    @Override
//    public Room showRoomDetails(Integer roomNumber) {
//        return rooms.stream()
//                .filter(room -> room.getRoomNumber().equals(roomNumber))
//                .findFirst()
//                .orElse(null);
//    }

