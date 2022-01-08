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
    public Optional<Guest> getGuest(Integer guestID) throws SQLException {
        String sql = "SELECT guestID, guestPassport, guestName, guestSurname, orderID " +
                "FROM Guest WHERE guestID=?";

        Guest guest = new Guest();

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, guestID);

            ResultSet resultSet = preparedStatement.executeQuery();

            guest.setGuestID(resultSet.getInt("guestID"));
            guest.setGuestPassport(resultSet.getInt("guestPassport"));
            guest.setGuestName(resultSet.getString("guestName"));
            guest.setGuestSurname(resultSet.getString("guestSurname"));
            guest.setOrderID(resultSet.getInt("orderID"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(guest);
    }

    @Override
    public List<Guest> getAllGuests() throws SQLException {
//        Connection connection = dbConnect.getConnection();
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
//        finally {
//            if (connection != null) {
//                connection.close();
//            }
//        }
        return guests;
    }

    @Override
    public void saveGuest(Guest guest) throws SQLException {
        String sql = "INSERT INTO Guest (guestID, guestPassport, guestName, guestSurname, orderID) " +
                "VALUES(?, ?, ?, ?, ?)";

        try (Connection connection = dbConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, guest.getGuestID());
            preparedStatement.setInt(2, guest.getGuestPassport());
            preparedStatement.setString(3, guest.getGuestName());
            preparedStatement.setString(4, guest.getGuestSurname());
            preparedStatement.setInt(5, guest.getOrderID());

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
}
//    private final List<Guest> guests = new ArrayList<>();
//
//    public GuestDaoImpl() {
//        super();
//    }
//
//    @Override
//    public Optional<Guest> get(Integer guestID) {
//        return Optional.ofNullable(guests.get(guestID));
//    }
//
//    @Override
//    public List<Guest> getAll() {
//        return guests;
//    }
//
//    @Override
//    public void save(Guest guest) {
//        guests.add(guest);
//    }
//
//    @Override
//    public void update(Guest guest) {
//        if (!guests.contains(guest)) {
//            guests.add(guest);
//        } else {
//            System.out.println("Such an object already exists!");
//        }
//    }
//
//    @Override
//    public void delete(Guest guest) {
//        guests.remove(guest);
//    }
//
//    @Override
//    public Integer getNumberOfGuests() {
//        return guests.size();
//    }
//}
