package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class BookingOrderDaoImpl implements IBookingOrderRepo {
    private final List<BookingOrder> bookingOrders = new ArrayList<>();

    @Override
    public Optional<BookingOrder> get(Integer bookingOrderID) {
        return Optional.ofNullable(bookingOrders.get(bookingOrderID));
    }

    @Override
    public List<BookingOrder> getAll() {
        return bookingOrders;
    }

    @Override
    public void save(BookingOrder bookingOrder) {
        bookingOrders.add(bookingOrder);
    }

    @Override
    public void update(BookingOrder bookingOrder) {
        if (!bookingOrders.contains(bookingOrder)) {
            bookingOrders.add(bookingOrder);
        } else {
            System.out.println("Such an object already exists!");
        }
    }

    @Override
    public void delete(BookingOrder bookingOrder) {
        bookingOrders.remove(bookingOrder);
    }

    @Override
    public List<BookingOrder> getLastThreeGuestsRoom(Integer roomNumber) {
        return bookingOrders.stream()
                .filter(bookingOrder -> bookingOrder.getOrderedRoom().getRoomNumber().equals(roomNumber))
                .filter(order -> order.getOrderStatus().equals(OrderStatus.CHECK_OUT))
                .filter(bookingOrder -> bookingOrder.getOrderCheckInDate().
                        isBefore(LocalDate.now().plusDays(1)))
                .sorted((o1, o2) -> o2.getOrderCheckInDate().compareTo(o1.getOrderCheckInDate()))
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByRoom() {
        return bookingOrders.stream()
                .filter(bookingOrder -> bookingOrder.getOrderStatus().equals(OrderStatus.CHECK_IN))
                .sorted(Comparator.comparing(o -> o.getOrderedRoom().getRoomNumber()))
                .collect(Collectors.toList());
    }


    @Override
    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByCheckOutDays() {
        return bookingOrders.stream()
                .filter(bookingOrder -> bookingOrder.getOrderStatus().equals(OrderStatus.CHECK_IN))
                .sorted(Comparator.comparing(BookingOrder::getOrderCheckOutDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<AdditionalService> getListAdditionalServiceOfGuestSortedByPrice(Integer guestID) {
        List<AdditionalService> list = new ArrayList<>();
        for (BookingOrder order : bookingOrders) {
            for (Guest guest : order.getOrderedGuests()) {
                if (guest.getGuestID().equals(guestID)) {
                    list = order.getOrderedAdServ().stream()
                            .sorted(Comparator.comparing(AdditionalService::getServicePrice))
                            .collect(Collectors.toList());
                }
            }
        }
        return list;
    }
}
