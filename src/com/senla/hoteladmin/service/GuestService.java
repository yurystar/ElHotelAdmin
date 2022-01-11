package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.IGuestRepo;
import com.senla.hoteladmin.entity.Guest;
import com.senla.hoteladmin.util.DbConnect;
import com.senla.hoteladmin.util.IDbConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GuestService implements IGuestService {
    private IGuestRepo guestRepo;

    public GuestService(IGuestRepo guestRepo) {
        this.guestRepo = guestRepo;
    }




    //    public GuestService(IGuestRepo guestRepo) {
//        this.guestRepo = guestRepo;
//    }
//
//    @Override
//    public void addGuestInStorage(Guest guest) {
//        guestRepo.save(guest);
//    }
//
//    @Override
//    public void removeGuestFromStorage(Guest guest) {
//        guestRepo.delete(guest);
//    }
//
//    @Override
//    public List<Guest> getGuestsHotel() {
//        return guestRepo.getAll();
//    }
//
//    @Override
//    public long getNumberGuestsHotel() {
//        return guestRepo.getNumberOfGuests();
//    }
}
