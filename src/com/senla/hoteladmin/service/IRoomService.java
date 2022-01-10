package com.senla.hoteladmin.service;

import com.senla.hoteladmin.entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface IRoomService {
    String createRoomSqlStr(String columnName);

    List<Room> getSortedHotelRooms(String columnName) throws SQLException;

    List<Room> getHotelRoomsSortedByRoomPlaces() throws SQLException;

    List<Room> getHotelRoomsSortedByRoomPrice() throws SQLException;

    List<Room> getHotelRoomsSortedByRoomType() throws SQLException;

    String createEmptyRoomSqlStr(String columnName);

    List<Room> getEmptySortedHotelRooms(String columnName) throws SQLException;
//
    List<Room> getEmptyHotelRoomsSortedByRoomPlaces() throws SQLException;

    List<Room> getEmptyHotelRoomsSortedByRoomPrice() throws SQLException;

    List<Room> getEmptyHotelRoomsSortedByRoomType() throws SQLException;

//    long getNumberEmptyHotelRooms();

//    void setNewRoom(Room room);

//    void deleteRoom(Room room);
//
//    Room getRoomByNumber(Integer roomNumber);
//
//    List<Room> getRoomList();
//
//    void setNewPriceRoom(Integer roomNumber, Integer priceRoom);
//
//    Room showRoomDetails(Integer roomNumber);
}
