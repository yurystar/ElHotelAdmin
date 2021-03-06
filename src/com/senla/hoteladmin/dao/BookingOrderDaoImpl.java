package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.*;
import com.senla.hoteladmin.util.IDbConnect;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookingOrderDaoImpl implements IBookingOrderRepo {
    IDbConnect dbConnect;

    public BookingOrderDaoImpl(IDbConnect dbConnect) {
        this.dbConnect = dbConnect;
    }

    @Override
    public BookingOrder getBookingOrder(Integer orderID) throws SQLException {
        String sql = "SELECT orderID, orderCreateDate, orderCheckInDate, orderCheckOutDate, " +
                "orderedRoom, orderStatus FROM BookingOrder WHERE orderID=?";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        BookingOrder bookingOrder = new BookingOrder();

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, orderID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                bookingOrder.setOrderID(resultSet.getInt("orderID"));
                bookingOrder.setOrderCreateDate(
                        LocalDate.parse(resultSet.getString
                                ("orderCreateDate"), dateTimeFormatter));
                bookingOrder.setOrderCheckInDate(
                        LocalDate.parse(resultSet.getString
                                ("orderCheckInDate"), dateTimeFormatter));
                bookingOrder.setOrderCheckOutDate(
                        LocalDate.parse(resultSet.getString
                                ("orderCheckOutDate"), dateTimeFormatter));
                bookingOrder.setOrderedRoom(resultSet.getInt("orderedRoom"));
                bookingOrder.setOrderStatus(
                        OrderStatus.valueOf(resultSet.getString("orderStatus")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookingOrder;
    }

    @Override
    public List<BookingOrder> getAllBookingOrders() throws SQLException {
        List<BookingOrder> bookingOrders = new ArrayList<>();

        String sql = "SELECT orderID, orderCreateDate, orderCheckInDate, orderCheckOutDate, " +
                "orderedRoom, orderStatus FROM BookingOrder";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (Connection connection = dbConnect.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                BookingOrder bookingOrder = new BookingOrder();

                bookingOrder.setOrderID(resultSet.getInt("orderID"));
                bookingOrder.setOrderCreateDate(
                        LocalDate.parse(resultSet.getString
                                ("orderCreateDate"), dateTimeFormatter));
                bookingOrder.setOrderCheckInDate(
                        LocalDate.parse(resultSet.getString
                                ("orderCheckInDate"), dateTimeFormatter));
                bookingOrder.setOrderCheckOutDate(
                        LocalDate.parse(resultSet.getString
                                ("orderCheckOutDate"), dateTimeFormatter));
                bookingOrder.setOrderedRoom(resultSet.getInt("orderedRoom"));
                bookingOrder.setOrderStatus(
                        OrderStatus.valueOf(resultSet.getString("orderStatus")));

                bookingOrders.add(bookingOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookingOrders;
    }

    @Override
    public void saveBookingOrder(BookingOrder bookingOrder) throws SQLException {
        String sql = "INSERT INTO BookingOrder (orderCreateDate, orderCheckInDate, " +
                "orderCheckOutDate, orderedRoom, orderStatus) " +
                "VALUES(?, ?, ?, ?, ?)";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String createDate = dateTimeFormatter.format(bookingOrder.getOrderCreateDate());
        String checkInDate = dateTimeFormatter.format(bookingOrder.getOrderCheckInDate());
        String checkOutDate = dateTimeFormatter.format(bookingOrder.getOrderCheckOutDate());

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, createDate);
            preparedStatement.setString(2, checkInDate);
            preparedStatement.setString(3, checkOutDate);
            preparedStatement.setInt(4, bookingOrder.getOrderedRoom());
            preparedStatement.setString(5, bookingOrder.getOrderStatus().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBookingOrder(BookingOrder bookingOrder) throws SQLException {
        String sql = "UPDATE BookingOrder SET orderCreateDate=?, orderCheckInDate=?, " +
                "orderCheckOutDate=?, orderedRoom=?, orderStatus=? " +
                "WHERE orderID=?";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String createDate = dateTimeFormatter.format(bookingOrder.getOrderCreateDate());
        String checkInDate = dateTimeFormatter.format(bookingOrder.getOrderCheckInDate());
        String checkOutDate = dateTimeFormatter.format(bookingOrder.getOrderCheckOutDate());

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, createDate);
            preparedStatement.setString(2, checkInDate);
            preparedStatement.setString(3, checkOutDate);
            preparedStatement.setInt(4, bookingOrder.getOrderedRoom());
            preparedStatement.setString(5, bookingOrder.getOrderStatus().toString());
            preparedStatement.setInt(6, bookingOrder.getOrderID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBookingOrder(BookingOrder bookingOrder) throws SQLException {
        String sql = "DELETE FROM BookingOrder WHERE orderID=?";

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, bookingOrder.getOrderID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setBookingOrderChekInStatus(Integer orderID) throws SQLException {
        BookingOrder bookingOrder = getBookingOrder(orderID);
        if (bookingOrder != null) {
            bookingOrder.setOrderStatus(OrderStatus.CHECK_IN);
        }
        updateBookingOrder(bookingOrder);
    }

    @Override
    public void setBookingOrderChekOutStatus(Integer orderID) throws SQLException {
        BookingOrder bookingOrder = getBookingOrder(orderID);
        if (bookingOrder != null) {
            bookingOrder.setOrderStatus(OrderStatus.CHECK_OUT);
        }
        updateBookingOrder(bookingOrder);
    }
}
