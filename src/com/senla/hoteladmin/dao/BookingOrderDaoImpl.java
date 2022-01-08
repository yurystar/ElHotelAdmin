package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.*;
import com.senla.hoteladmin.util.IDbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class BookingOrderDaoImpl implements IBookingOrderRepo {
    IDbConnect dbConnect;

    public BookingOrderDaoImpl(IDbConnect dbConnect) {
        this.dbConnect = dbConnect;
    }

    @Override
    public Optional<BookingOrder> getBookingOrder(Integer orderID) throws SQLException {
        String sql = "SELECT orderID, orderCreateDate, orderCheckInDate, orderCheckOutDate, " +
                "orderedRoomNum, orderStatus FROM BookingOrder WHERE orderID=?";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        BookingOrder bookingOrder = new BookingOrder();

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, orderID);

            ResultSet resultSet = preparedStatement.executeQuery();

            bookingOrder.setOrderID(resultSet.getInt("orderID"));
            bookingOrder.setOrderCreateDate(
                    LocalDate.parse(resultSet.getString("orderCreateDate"), dateTimeFormatter));
            bookingOrder.setOrderCheckInDate(
                    LocalDate.parse(resultSet.getString("orderCheckInDate"), dateTimeFormatter));
            bookingOrder.setOrderCheckOutDate(
                    LocalDate.parse(resultSet.getString("orderCheckOutDate"), dateTimeFormatter));
            bookingOrder.setOrderedRoomNum(resultSet.getInt("orderedRoomNum"));
            bookingOrder.setOrderStatus(OrderStatus.valueOf(resultSet.getString("orderStatus")));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(bookingOrder);
    }

    @Override
    public List<BookingOrder> getAllBookingOrders() throws SQLException {
        return null;
    }

    @Override
    public void saveBookingOrder(BookingOrder bookingOrder) throws SQLException {
        String sql = "INSERT INTO BookingOrder (orderID, orderCreateDate, orderCheckInDate, " +
                "orderCheckOutDate, orderedRoomNum, orderStatus) " +
                "VALUES(?, ?, ?, ?, ?, ?)";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String createDate = dateTimeFormatter.format(bookingOrder.getOrderCreateDate());
        String checkInDate = dateTimeFormatter.format(bookingOrder.getOrderCheckInDate());
        String checkOutDate = dateTimeFormatter.format(bookingOrder.getOrderCheckOutDate());

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, bookingOrder.getOrderID());
            preparedStatement.setString(2, createDate);
            preparedStatement.setString(3, checkInDate);
            preparedStatement.setString(4, checkOutDate);
            preparedStatement.setInt(5, bookingOrder.getOrderedRoomNum());
            preparedStatement.setString(6, bookingOrder.getOrderStatus().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBookingOrder(BookingOrder bookingOrder) throws SQLException {

    }

    @Override
    public void deleteBookingOrder(BookingOrder bookingOrder) throws SQLException {

    }
}

//    @Override
//    public List<BookingOrder> getLastThreeGuestsRoom(Integer roomNumber) {
//        return bookingOrders.stream()
//                .filter(bookingOrder -> bookingOrder.getOrderedRoom().getRoomNumber().equals(roomNumber))
//                .filter(order -> order.getOrderStatus().equals(OrderStatus.CHECK_OUT))
//                .filter(bookingOrder -> bookingOrder.getOrderCheckInDate().
//                        isBefore(LocalDate.now().plusDays(1)))
//                .sorted((o1, o2) -> o2.getOrderCheckInDate().compareTo(o1.getOrderCheckInDate()))
//                .limit(3)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByRoom() {
//        return bookingOrders.stream()
//                .filter(bookingOrder -> bookingOrder.getOrderStatus().equals(OrderStatus.CHECK_IN))
//                .sorted(Comparator.comparing(o -> o.getOrderedRoom().getRoomNumber()))
//                .collect(Collectors.toList());
//    }
//
//
//    @Override
//    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByCheckOutDays() {
//        return bookingOrders.stream()
//                .filter(bookingOrder -> bookingOrder.getOrderStatus().equals(OrderStatus.CHECK_IN))
//                .sorted(Comparator.comparing(BookingOrder::getOrderCheckOutDate))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<AdditionalService> getListAdditionalServiceOfGuestSortedByPrice(Integer guestID) {
//        List<AdditionalService> list = new ArrayList<>();
//        for (BookingOrder order : bookingOrders) {
//            for (Guest guest : order.getOrderedGuests()) {
//                if (guest.getGuestID().equals(guestID)) {
//                    list = order.getOrderedAdServ().stream()
//                            .sorted(Comparator.comparing(AdditionalService::getServicePrice))
//                            .collect(Collectors.toList());
//                }
//            }
//        }
//        return list;
//    }
//}
