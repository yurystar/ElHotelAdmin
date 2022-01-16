package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.Room;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IRoomRepo {
    Room getRoom(Integer roomNum) throws SQLException;

    List<Room> getAllRooms(String sql) throws SQLException;

    void saveRoom(Room room) throws SQLException;

    void updateRoom(Room room) throws SQLException;

    void deleteRoom(Room room) throws SQLException;

    String createRoomSqlStr(String columnName);

    List<Room> getHotelRoomsSortedByRoomNumber() throws SQLException;

    List<Room> getHotelRoomsSortedByRoomPlaces() throws SQLException;

    List<Room> getHotelRoomsSortedByRoomPrice() throws SQLException;

    List<Room> getHotelRoomsSortedByRoomType() throws SQLException;

    String createEmptyRoomSqlStr(String columnName);

    List<Room> getEmptyHotelRoomsSortedByRoomNumber() throws SQLException;

    List<Room> getEmptyHotelRoomsSortedByRoomPlaces() throws SQLException;

    List<Room> getEmptyHotelRoomsSortedByRoomPrice() throws SQLException;

    List<Room> getEmptyHotelRoomsSortedByRoomType() throws SQLException;

    List<Room> getBusyRoomListOnDate(LocalDate date) throws SQLException;

    List<Room> getEmptyRoomListOnDate(LocalDate date) throws SQLException;

    Integer getNumberEmptyHotelRooms() throws SQLException;

    void setRoomChekInStatus(Integer roomNumber) throws SQLException;

    void setRoomEmptyStatus(Integer roomNumber) throws SQLException;

    void setRoomStatusOnRepair(Integer roomNumber) throws SQLException;

    void setRoomNewPrice (Integer roomNumber, Integer newPrice) throws SQLException;
}
