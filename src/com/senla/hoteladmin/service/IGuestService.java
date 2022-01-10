package com.senla.hoteladmin.service;

import com.senla.hoteladmin.entity.Guest;

import java.util.List;

public interface IGuestService {
    void showListGuestsAndTheirRoomsSortedBySurname();

    Integer getNumberGuestsHotel();
//
//    void addGuestInStorage(Guest guest);
//
//    void removeGuestFromStorage(Guest guest);
}
