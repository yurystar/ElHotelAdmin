package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.IRoomRepo;
import com.senla.hoteladmin.entity.Room;
import com.senla.hoteladmin.entity.RoomStatus;
import com.senla.hoteladmin.entity.RoomType;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RoomService implements IRoomService {
    private IRoomRepo roomRepo;

    public RoomService(IRoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public String createRoomSqlStr(String columnName) {
        return "SELECT roomNumber, roomType, roomPlaces, roomPrice, roomStatus FROM Room " +
                "ORDER BY " + columnName;
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomNumber() throws SQLException {
        return roomRepo.getAllRooms(createRoomSqlStr("roomNumber"));
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomPlaces() throws SQLException {
        return roomRepo.getAllRooms(createRoomSqlStr("roomPlaces"));
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomPrice() throws SQLException {
        return roomRepo.getAllRooms(createRoomSqlStr("roomPrice"));
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomType() throws SQLException {
        return roomRepo.getAllRooms(createRoomSqlStr("roomType"));
    }

    @Override
    public String createEmptyRoomSqlStr(String columnName) {
        return "SELECT roomNumber, roomType, roomPlaces, roomPrice, roomStatus FROM Room " +
                "WHERE roomStatus = \"EMPTY\" ORDER BY " + columnName;
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomNumber() throws SQLException {
        return roomRepo.getAllRooms(createEmptyRoomSqlStr("roomNumber"));
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomPlaces() throws SQLException {
        return roomRepo.getAllRooms(createEmptyRoomSqlStr("roomPlaces"));
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomPrice() throws SQLException {
        return roomRepo.getAllRooms(createEmptyRoomSqlStr("roomPrice"));
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomType() throws SQLException {
        return roomRepo.getAllRooms(createEmptyRoomSqlStr("roomType"));
    }

    @Override
    public List<Room> getBusyRoomListOnDate(LocalDate date) throws SQLException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String searchDate = dateTimeFormatter.format(date);
        return roomRepo.getAllRooms("select b.roomNumber, b.roomType, b.roomPlaces, b.roomPrice, b.roomStatus \n" +
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
}

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

