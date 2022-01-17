package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.Guest;

import java.sql.SQLException;
import java.util.List;

public interface IGuestRepo {
    Guest getGuest(Integer guestID) throws SQLException;

    List<Guest> getAllGuests() throws SQLException;

    void saveGuest(Guest guest) throws SQLException;

    void updateGuest(Guest guest) throws SQLException;

    void deleteGuest(Guest guest) throws SQLException;

    void showListGuestsAndTheirRoomsSortedBySurname();

    void showListGuestsAndTheirRoomsSortedByCheckOutDate();

    Integer getNumberGuestsHotel();

    Integer getIDOrderOfGuest(Integer guestID) throws SQLException;
}
