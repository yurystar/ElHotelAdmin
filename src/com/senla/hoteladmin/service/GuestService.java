package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.IGuestRepo;

import java.sql.SQLException;

public class GuestService implements IGuestService {
    private IGuestRepo guestRepo;

    public GuestService(IGuestRepo guestRepo) {
        this.guestRepo = guestRepo;
    }

    @Override
    public void showListGuestsAndTheirRoomsSortedBySurname() {
        guestRepo.showListGuestsAndTheirRoomsSortedBySurname();
    }

    @Override
    public void showListGuestsAndTheirRoomsSortedByCheckOutDate() {
        guestRepo.showListGuestsAndTheirRoomsSortedByCheckOutDate();
    }

    @Override
    public Integer getNumberGuestsHotel() {
        return guestRepo.getNumberGuestsHotel();
    }

    @Override
    public Integer getIDOrderOfGuest(Integer guestID) throws SQLException {
        return guestRepo.getIDOrderOfGuest(guestID);
    }
}
