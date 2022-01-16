package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.IRoomRepo;
import com.senla.hoteladmin.entity.Room;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RoomService implements IRoomService {
    private IRoomRepo roomRepo;

    public RoomService(IRoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public Room getRoom(Integer roomNum) throws SQLException {
        return roomRepo.getRoom(roomNum);
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomNumber() throws SQLException {
        return roomRepo.getHotelRoomsSortedByRoomNumber();
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomPlaces() throws SQLException {
        return roomRepo.getHotelRoomsSortedByRoomPlaces();
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomPrice() throws SQLException {
        return roomRepo.getHotelRoomsSortedByRoomPrice();
    }

    @Override
    public List<Room> getHotelRoomsSortedByRoomType() throws SQLException {
        return roomRepo.getHotelRoomsSortedByRoomType();
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomNumber() throws SQLException {
        return roomRepo.getEmptyHotelRoomsSortedByRoomNumber();
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomPlaces() throws SQLException {
        return roomRepo.getEmptyHotelRoomsSortedByRoomPlaces();
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomPrice() throws SQLException {
        return roomRepo.getEmptyHotelRoomsSortedByRoomPrice();
    }

    @Override
    public List<Room> getEmptyHotelRoomsSortedByRoomType() throws SQLException {
        return roomRepo.getEmptyHotelRoomsSortedByRoomType();
    }

    @Override
    public List<Room> getBusyRoomListOnDate(LocalDate date) throws SQLException {
        return roomRepo.getBusyRoomListOnDate(date);
    }

    @Override
    public List<Room> getEmptyRoomListOnDate(LocalDate date) throws SQLException {
        return roomRepo.getEmptyRoomListOnDate(date);
    }

    @Override
    public void setRoomChekInStatus(Integer roomNumber) throws SQLException {
        roomRepo.setRoomChekInStatus(roomNumber);
    }

    @Override
    public void setRoomEmptyStatus(Integer roomNumber) throws SQLException {
        roomRepo.setRoomEmptyStatus(roomNumber);
    }

    @Override
    public void setRoomNewPrice(Integer roomNumber, Integer newPrice) throws SQLException {
        roomRepo.setRoomNewPrice(roomNumber, newPrice);
    }
}
