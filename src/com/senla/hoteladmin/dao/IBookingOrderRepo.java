package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.AdditionalService;
import com.senla.hoteladmin.entity.BookingOrder;

import java.util.List;

public interface IBookingOrderRepo extends IDao<BookingOrder> {
    List<BookingOrder> getLastThreeGuestsRoom(Integer roomNumber);

    List<BookingOrder> getListGuestsAndTheirRoomsSortedByRoom();

    List<BookingOrder> getListGuestsAndTheirRoomsSortedByCheckOutDays();

    List<AdditionalService> getListAdditionalServiceOfGuestSortedByPrice(Integer guestID);
}
