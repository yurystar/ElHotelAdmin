package com.senla.hoteladmin.service;

import com.senla.hoteladmin.entity.Guest;

import java.util.List;

public interface IGuestService {
    void showListGuestsAndTheirRoomsSortedBySurname();

    void showListGuestsAndTheirRoomsSortedByCheckOutDate();

    Integer getNumberGuestsHotel();
//
//    void addGuestInStorage(Guest guest);
//
//    void removeGuestFromStorage(Guest guest);
}
