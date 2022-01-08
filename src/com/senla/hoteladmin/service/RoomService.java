package com.senla.hoteladmin.service;

import com.senla.hoteladmin.entity.Room;
import com.senla.hoteladmin.entity.RoomStatus;
import com.senla.hoteladmin.entity.RoomType;
import com.senla.hoteladmin.util.DbConnect;
import com.senla.hoteladmin.util.IDbConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomService implements IRoomService {
IDbConnect dbConnect;

    public RoomService(IDbConnect dbConnect) {
        this.dbConnect = dbConnect;
    }
//    private final IRoomRepo roomRepo;


//    public RoomService(IRoomRepo roomRepo) {
//        this.roomRepo = roomRepo;
//    }
//
    @Override
    public List<Room> getHotelRoomsSortedByRoomPlaces() throws SQLException {
        Connection connection = dbConnect.getConnection();
        List<Room> rooms = new ArrayList<>();

        String sql = "SELECT roomNumber, roomType, roomPlaces, roomPrice, roomStatus FROM Room " +
                "ORDER BY roomPlaces";

        try (Statement statement = connection.createStatement()) {

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
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return rooms;
    }
//
//    @Override
//    public List<Room> getHotelRoomsSortedByRoomPrice() {
//        return roomRepo.getHotelRoomsSortedByRoomPrice();
//    }
//
//    @Override
//    public List<Room> getHotelRoomsSortedByRoomType() {
//        return roomRepo.getHotelRoomsSortedByRoomType();
//    }
//
//    @Override
//    public List<Room> getEmptyHotelRoomsSortedByRoomPlaces() {
//        return roomRepo.getEmptyHotelRoomsSortedByRoomPlaces();
//    }
//
//    @Override
//    public List<Room> getEmptyHotelRoomsSortedByRoomPrice() {
//        return roomRepo.getEmptyHotelRoomsSortedByRoomPrice();
//    }
//
//    @Override
//    public List<Room> getEmptyHotelRoomsSortedByRoomType() {
//        return roomRepo.getEmptyHotelRoomsSortedByRoomType();
//    }
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
