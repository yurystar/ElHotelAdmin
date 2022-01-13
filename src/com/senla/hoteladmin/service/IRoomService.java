package com.senla.hoteladmin.service;

import com.senla.hoteladmin.entity.Room;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface IRoomService {
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

    void setRoomChekInStatus(Integer roomNumber) throws SQLException;

    void setRoomEmptyStatus(Integer roomNumber) throws SQLException;

    void setRoomNewPrice (Integer roomNumber, Integer newPrice) throws SQLException;
}
