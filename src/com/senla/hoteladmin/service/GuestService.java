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
    private IDbConnect dbConnect;

    public GuestService(IDbConnect dbConnect) {
        this.dbConnect = dbConnect;
    }

    @Override
    public void showListGuestsAndTheirRoomsSortedBySurname() {
        String sql = "select Guest.guestID, Guest.guestName, Guest.guestSurname, BookingOrder.orderCheckOutDate, " +
                "Room.roomNumber from Guest " +
                "inner join BookingOrder on Guest.orderID = BookingOrder.orderID " +
                "inner join Room on BookingOrder.orderedRoom = Room.roomNumber " +
                "order by Guest.guestSurname";

        try (Connection connection = dbConnect.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                System.out.printf("%d ", resultSet.getInt("guestID"));
                System.out.printf("Name - %s, ", resultSet.getString("guestName"));
                System.out.printf("Surname - %s, ", resultSet.getString("guestSurname"));
                System.out.printf("Date check-out - %s, ", resultSet.getString("orderCheckOutDate"));
                System.out.printf("Room number - %s. \n", resultSet.getInt("roomNumber"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer getNumberGuestsHotel() {
        return null;
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
