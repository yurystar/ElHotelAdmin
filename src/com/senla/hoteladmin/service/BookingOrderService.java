package com.senla.hoteladmin.service;

import com.senla.hoteladmin.dao.IBookingOrderRepo;
import com.senla.hoteladmin.entity.AdditionalService;
import com.senla.hoteladmin.entity.BookingOrder;
import com.senla.hoteladmin.util.DbConnect;

import java.util.List;

public class BookingOrderService  implements IBookingOrderService {
    private DbConnect dbConnect;

    public BookingOrderService(DbConnect dbConnect) {
        this.dbConnect = dbConnect;
    }

    @Override
    public void saveNewBookingOrder(BookingOrder order) {

    }

    //    public BookingOrderService(IBookingOrderRepo bookingOrderRepo) {
//        this.bookingOrderRepo = bookingOrderRepo;
//    }
//
//    @Override
//    public List<BookingOrder> getLastThreeGuestsRoom(Integer roomNumber) {
//        return bookingOrderRepo.getLastThreeGuestsRoom(roomNumber);
//    }
//
//    @Override
//    public List<BookingOrder> getListBookingOrders() {
//        return bookingOrderRepo.getAll();
//    }
//
//    @Override
//    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByRoom() {
//        return bookingOrderRepo.getListGuestsAndTheirRoomsSortedByRoom();
//    }
//
//    @Override
//    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByCheckOutDays() {
//        return bookingOrderRepo.getListGuestsAndTheirRoomsSortedByCheckOutDays();
//    }
//
//    @Override
//    public void saveNewBookingOrder(BookingOrder order) {
//        bookingOrderRepo.save(order);
//    }
//
//    @Override
//    public List<AdditionalService> getListAdditionalServiceOfGuestSortedByPrice(Integer guestID) {
//        return bookingOrderRepo.getListAdditionalServiceOfGuestSortedByPrice(guestID);
//    }
}
