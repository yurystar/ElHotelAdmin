package com.senla.hoteladmin.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class BookingOrder {
    private Integer orderID;
    private LocalDate orderCreateDate;
    private LocalDate orderCheckInDate;
    private LocalDate orderCheckOutDate;
    private Integer orderedRoomNum;
    private OrderStatus orderStatus;

    public BookingOrder() {
    }

    public BookingOrder(Integer orderID, LocalDate orderCreateDate, LocalDate orderCheckInDate,
                        LocalDate orderCheckOutDate, Integer orderedRoomNum, OrderStatus orderStatus) {
        this.orderID = orderID;
        this.orderCreateDate = orderCreateDate;
        this.orderCheckInDate = orderCheckInDate;
        this.orderCheckOutDate = orderCheckOutDate;
        this.orderedRoomNum = orderedRoomNum;
        this.orderStatus = orderStatus;
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

    public Integer getOrderedRoomNum() {
        return orderedRoomNum;
    }

    public void setOrderedRoomNum(Integer orderedRoomNum) {
        this.orderedRoomNum = orderedRoomNum;
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
        BookingOrder that = (BookingOrder) o;
        return getOrderID().equals(that.getOrderID()) && getOrderCreateDate().equals(that.getOrderCreateDate()) && getOrderCheckInDate().equals(that.getOrderCheckInDate()) && getOrderCheckOutDate().equals(that.getOrderCheckOutDate()) && getOrderedRoomNum().equals(that.getOrderedRoomNum()) && getOrderStatus() == that.getOrderStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderID(), getOrderCreateDate(), getOrderCheckInDate(), getOrderCheckOutDate(), getOrderedRoomNum(), getOrderStatus());
    }

    @Override
    public String toString() {
        return "BookingOrder{" +
                "orderID=" + orderID +
                ", orderCreateDate=" + orderCreateDate +
                ", orderCheckInDate=" + orderCheckInDate +
                ", orderCheckOutDate=" + orderCheckOutDate +
                ", orderedRoomNum=" + orderedRoomNum +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
