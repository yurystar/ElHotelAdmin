package com.senla.hoteladmin.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class BookingOrder {
    private Integer orderID;
    private LocalDate orderCreateDate;
    private LocalDate orderCheckInDate;
    private LocalDate orderCheckOutDate;
    private Room orderedRoom;
    private List<AdditionalService> orderedAdServ;
    private List<Guest> orderedGuests;
    private OrderStatus orderStatus;

    public BookingOrder(Integer orderID, LocalDate orderCheckInDate,
                        LocalDate orderCheckOutDate, Room orderedHotelRoom,
                        List<AdditionalService> orderedAdditionalServices, List<Guest> orderHotelGuests,
                        OrderStatus orderStatus) {
        this.orderID = orderID;
        this.orderCreateDate = LocalDate.now();
        this.orderCheckInDate = orderCheckInDate;
        this.orderCheckOutDate = orderCheckOutDate;
        this.orderedRoom = orderedHotelRoom;
        this.orderedAdServ = orderedAdditionalServices;
        this.orderedGuests = orderHotelGuests;
        this.orderStatus = orderStatus;
    }

    public BookingOrder(List<AdditionalService> orderedAdditionalServices) {
        this.orderedAdServ = orderedAdditionalServices;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public LocalDate getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(LocalDate orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public LocalDate getOrderCheckInDate() {
        return orderCheckInDate;
    }

    public void setOrderCheckInDate(LocalDate orderCheckInDate) {
        this.orderCheckInDate = orderCheckInDate;
    }

    public LocalDate getOrderCheckOutDate() {
        return orderCheckOutDate;
    }

    public void setOrderCheckOutDate(LocalDate orderCheckOutDate) {
        this.orderCheckOutDate = orderCheckOutDate;
    }

    public Room getOrderedRoom() {
        return orderedRoom;
    }

    public void setOrderedRoom(Room orderedRoom) {
        this.orderedRoom = orderedRoom;
    }

    public List<AdditionalService> getOrderedAdServ() {
        return orderedAdServ;
    }

    public void setOrderedAdServ(List<AdditionalService> orderedAdServ) {
        this.orderedAdServ = orderedAdServ;
    }

    public List<Guest> getOrderedGuests() {
        return orderedGuests;
    }

    public void setOrderedGuests(List<Guest> orderedGuests) {
        this.orderedGuests = orderedGuests;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingOrder)) return false;
        BookingOrder order = (BookingOrder) o;
        return getOrderID().equals(order.getOrderID()) && getOrderCreateDate().equals(order.getOrderCreateDate()) && getOrderCheckInDate().equals(order.getOrderCheckInDate()) && getOrderCheckOutDate().equals(order.getOrderCheckOutDate()) && getOrderedRoom().equals(order.getOrderedRoom()) && Objects.equals(getOrderedAdServ(), order.getOrderedAdServ()) && getOrderedGuests().equals(order.getOrderedGuests()) && getOrderStatus() == order.getOrderStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderID(), getOrderCreateDate(), getOrderCheckInDate(), getOrderCheckOutDate(), getOrderedRoom(), getOrderedAdServ(), getOrderedGuests(), getOrderStatus());
    }

    @Override
    public String toString() {
        return "BookingOrder{" +
                "orderID=" + orderID +
                ", orderCreateDate=" + orderCreateDate +
                ", orderCheckInDate=" + orderCheckInDate +
                ", orderCheckOutDate=" + orderCheckOutDate +
                ", orderedRoom=" + orderedRoom +
                ", orderedAdServ=" + orderedAdServ +
                ", orderedGuests=" + orderedGuests +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
