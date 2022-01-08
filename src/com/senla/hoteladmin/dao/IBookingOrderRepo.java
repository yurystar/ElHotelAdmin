package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.AdditionalService;
import com.senla.hoteladmin.entity.BookingOrder;
import com.senla.hoteladmin.entity.Room;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IBookingOrderRepo {
    Optional<BookingOrder> getBookingOrder(Integer orderID) throws SQLException;

    List<BookingOrder> getAllBookingOrders() throws SQLException;

    void saveBookingOrder(BookingOrder bookingOrder) throws SQLException;

    void updateBookingOrder(BookingOrder bookingOrder) throws SQLException;

    void deleteBookingOrder(BookingOrder bookingOrder) throws SQLException;

//    List<BookingOrder> getLastThreeGuestsRoom(Integer roomNumber);
//
//    List<BookingOrder> getListGuestsAndTheirRoomsSortedByRoom();
//
//    List<BookingOrder> getListGuestsAndTheirRoomsSortedByCheckOutDays();
//
//    List<AdditionalService> getListAdditionalServiceOfGuestSortedByPrice(Integer guestID);
}
