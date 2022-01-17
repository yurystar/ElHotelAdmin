package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.Guest;
import com.senla.hoteladmin.entity.Room;
import com.senla.hoteladmin.entity.RoomStatus;
import com.senla.hoteladmin.entity.RoomType;
import com.senla.hoteladmin.util.IDbConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GuestDaoImpl implements IGuestRepo {
    IDbConnect dbConnect;

    public GuestDaoImpl(IDbConnect dbConnect) {
        this.dbConnect = dbConnect;
    }

    @Override
    public Guest getGuest(Integer guestID) throws SQLException {
        String sql = "SELECT guestID, guestPassport, guestName, guestSurname, orderID " +
                "FROM Guest WHERE guestID=?";

        Guest guest = new Guest();

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, guestID);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                guest.setGuestID(resultSet.getInt("guestID"));
                guest.setGuestPassport(resultSet.getInt("guestPassport"));
                guest.setGuestName(resultSet.getString("guestName"));
                guest.setGuestSurname(resultSet.getString("guestSurname"));
                guest.setOrderID(resultSet.getInt("orderID"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guest;
    }

    @Override
    public List<Guest> getAllGuests() throws SQLException {
        List<Guest> guests = new ArrayList<>();

        String sql = "SELECT guestID, guestPassport, guestName, guestSurname, orderID FROM Guest";

        try (Connection connection = dbConnect.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Guest guest = new Guest();
                guest.setGuestID(resultSet.getInt("guestID"));
                guest.setGuestPassport(resultSet.getInt("guestPassport"));
                guest.setGuestName(resultSet.getString("guestName"));
                guest.setGuestSurname(resultSet.getString("guestSurname"));
                guest.setOrderID(resultSet.getInt("orderID"));

                guests.add(guest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guests;
    }

    @Override
    public void saveGuest(Guest guest) throws SQLException {
        String sql = "INSERT INTO Guest (guestPassport, guestName, guestSurname, orderID) " +
                "VALUES(?, ?, ?, ?)";

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, guest.getGuestPassport());
            preparedStatement.setString(2, guest.getGuestName());
            preparedStatement.setString(3, guest.getGuestSurname());
            preparedStatement.setInt(4, guest.getOrderID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateGuest(Guest guest) throws SQLException {
        String sql = "UPDATE Guest SET guestPassport=?, guestName=?, guestSurname=?, orderID=? " +
                "WHERE guestID=?";

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, guest.getGuestPassport());
            preparedStatement.setString(2, guest.getGuestName());
            preparedStatement.setString(3, guest.getGuestSurname());
            preparedStatement.setInt(4, guest.getOrderID());
            preparedStatement.setInt(5, guest.getGuestID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGuest(Guest guest) throws SQLException {
        String sql = "DELETE FROM Guest WHERE guestID=?";

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, guest.getGuestID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public void showListGuestsAndTheirRoomsSortedByCheckOutDate() {
        String sql = "select Guest.guestID, Guest.guestName, Guest.guestSurname, BookingOrder.orderCheckOutDate, " +
                "Room.roomNumber from Guest " +
                "inner join BookingOrder on Guest.orderID = BookingOrder.orderID " +
                "inner join Room on BookingOrder.orderedRoom = Room.roomNumber " +
                "order by BookingOrder.orderCheckOutDate";

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
        String sql = "SELECT COUNT(guestID) as totalCount FROM Guest";

        Integer count = null;
        try (Connection connection = dbConnect.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                count = (resultSet.getInt("totalCount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Integer getIDOrderOfGuest(Integer guestID) throws SQLException {
        return getGuest(guestID).getOrderID();
    }
}
