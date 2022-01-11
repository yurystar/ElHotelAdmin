package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.Room;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IRoomRepo {
    Optional<Room> getRoom(Integer roomNum) throws SQLException;

    List<Room> getAllRooms(String sql) throws SQLException;

    void saveRoom(Room room) throws SQLException;

    void updateRoom(Room room) throws SQLException;

    void deleteRoom(Room room) throws SQLException;

    Integer getNumberEmptyHotelRooms() throws SQLException;

//    List<Room> getHotelRoomsSortedByRoomPlaces();
//
//    List<Room> getHotelRoomsSortedByRoomPrice();
//
//    List<Room> getHotelRoomsSortedByRoomType();
//
//    List<Room> getEmptyHotelRoomsSortedByRoomPlaces();
//
//    List<Room> getEmptyHotelRoomsSortedByRoomPrice();
//
//    List<Room> getEmptyHotelRoomsSortedByRoomType();
//
//    long getNumberEmptyHotelRooms();
//
//    void setNewPriceRoom(Integer roomNumber, Integer priceRoom);
//
//    Room showRoomDetails(Integer roomNumber);

}
