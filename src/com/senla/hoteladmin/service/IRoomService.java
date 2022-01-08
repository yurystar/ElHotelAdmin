package com.senla.hoteladmin.service;

import com.senla.hoteladmin.entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface IRoomService {

    List<Room> getHotelRoomsSortedByRoomPlaces() throws SQLException;

//    List<Room> getHotelRoomsSortedByRoomPrice();
//
//    List<Room> getHotelRoomsSortedByRoomType();
//
//    List<Room> getEmptyHotelRoomsSortedByRoomPlaces();
//
//    List<Room> getEmptyHotelRoomsSortedByRoomPrice();
//
//    List<Room> getEmptyHotelRoomsSortedByRoomType();

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
