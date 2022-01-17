package com.senla.hoteladmin.service;

import java.sql.SQLException;

public interface IGuestService {
    void showListGuestsAndTheirRoomsSortedBySurname();

    void showListGuestsAndTheirRoomsSortedByCheckOutDate();

    Integer getNumberGuestsHotel();

    Integer getIDOrderOfGuest(Integer guestID) throws SQLException;
}
