package com.senla.hoteladmin.service;

import com.senla.hoteladmin.entity.Room;
import com.senla.hoteladmin.entity.RoomStatus;
import com.senla.hoteladmin.entity.RoomType;
import com.senla.hoteladmin.util.IDbConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomService implements IRoomService {
    IDbConnect dbConnect;

    public RoomService(IDbConnect dbConnect) {
        this.dbConnect = dbConnect;
    }

    @Override
    public String createRoomSqlStr(String columnName) {
        return "SELECT roomNumber, roomType, roomPlaces, roomPrice, roomStatus FROM Room " +
                "ORDER BY " + columnName;
    }

    @Override
    public List<Room> getSortedHotelRooms(String columnName) throws SQLException {
        List<Room> rooms = new ArrayList<>();

        String sql = createRoomSqlStr(columnName);

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
    public List<Room> getHotelRoomsSortedByRoomPlaces() throws SQLException {
        return getSortedHotelRooms("roomPlaces");
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomPrice() throws SQLException {
        return getSortedHotelRooms("roomPrice");
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomType() throws SQLException {
        return getSortedHotelRooms("roomType");
    }

    @Override
    public String createEmptyRoomSqlStr(String columnName) {
        return "SELECT roomNumber, roomType, roomPlaces, roomPrice, roomStatus FROM Room " +
                "WHERE roomStatus = \"EMPTY\" ORDER BY " + columnName;
    }

    @Override
    public List<Room> getEmptySortedHotelRooms(String columnName) throws SQLException {
        List<Room> rooms = new ArrayList<>();

        String sql = createEmptyRoomSqlStr(columnName);

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
    public List<Room> getEmptyHotelRoomsSortedByRoomPlaces() throws SQLException {
        return getEmptySortedHotelRooms("roomPlaces");
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomPrice() throws SQLException {
        return getEmptySortedHotelRooms("roomPrice");
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomType() throws SQLException {
        return getEmptySortedHotelRooms("roomType");
    }
//
//    @Override
//    public long getNumberEmptyHotelRooms() {
//        return roomRepo.getNumberEmptyHotelRooms();
//    }
//
//    @Override
//    public void setNewRoom(Room room) {
//        roomRepo.save(room);
//    }
//
//    @Override
//    public void deleteRoom(Room room) {
//        roomRepo.delete(room);
//    }
//
//    @Override
//    public Room getRoomByNumber(Integer roomNumber) {
//        return roomRepo.getAll().stream()
//                .filter(room -> room.getRoomNumber().equals(roomNumber))
//                .findFirst()
//                .orElse(null);
//    }
//
//    @Override
//    public List<Room> getRoomList() {
//        return roomRepo.getAll();
//    }
//
//    @Override
//    public void setNewPriceRoom(Integer roomNumber, Integer priceRoom) {
//        roomRepo.setNewPriceRoom(roomNumber, priceRoom);
//    }
//
//    @Override
//    public Room showRoomDetails(Integer roomNumber) {
//        return roomRepo.showRoomDetails(roomNumber);
//    }
}
