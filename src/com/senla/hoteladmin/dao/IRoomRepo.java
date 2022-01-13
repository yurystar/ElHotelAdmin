package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.Room;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IRoomRepo {
    Room getRoom(Integer roomNum) throws SQLException;

    List<Room> getAllRooms(String sql) throws SQLException;

    void saveRoom(Room room) throws SQLException;

    void updateRoom(Room room) throws SQLException;

    void deleteRoom(Room room) throws SQLException;

    Integer getNumberEmptyHotelRooms() throws SQLException;

    void setRoomChekInStatus(Integer roomNumber) throws SQLException;

    void setRoomEmptyStatus(Integer roomNumber) throws SQLException;

    void setRoomStatusOnRepair(Integer roomNumber) throws SQLException;

    void setRoomNewPrice (Integer roomNumber, Integer newPrice) throws SQLException;
}
