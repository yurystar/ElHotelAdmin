package com.senla.hoteladmin.dao;

import com.senla.hoteladmin.entity.Guest;
import com.senla.hoteladmin.entity.Room;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IGuestRepo {
    Optional<Guest> getGuest(Integer guestID) throws SQLException;

    List<Guest> getAllGuests() throws SQLException;

    void saveGuest(Guest guest) throws SQLException;

    void updateGuest(Guest guest) throws SQLException;

    void deleteGuest(Guest guest) throws SQLException;

//    Integer getNumberOfGuests();
}
