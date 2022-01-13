package com.senla.hoteladmin.service;

import com.senla.hoteladmin.entity.AdditionalService;
import com.senla.hoteladmin.entity.BookingOrder;

import java.sql.SQLException;
import java.util.List;

public interface IBookingOrderService {
    void setBookingOrderChekInStatus(Integer orderID) throws SQLException;

    BookingOrder getBookingOrder(Integer orderID) throws SQLException;

    void setBookingOrderChekOutStatus(Integer orderID) throws SQLException;
}
