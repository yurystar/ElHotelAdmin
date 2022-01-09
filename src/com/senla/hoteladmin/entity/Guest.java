package com.senla.hoteladmin.entity;

import java.util.*;

public class Guest {
    private Integer guestID;
    private Integer guestPassport;
    private String guestName;
    private String guestSurname;
    private Integer orderID;

    public Guest() {
    }

    public Guest(Integer guestPassport, String guestName, String guestSurname,
                 Integer orderID) {
        this.guestPassport = guestPassport;
        this.guestName = guestName;
        this.guestSurname = guestSurname;
        this.orderID = orderID;
    }

    public Guest(Integer guestID, Integer guestPassport, String guestName, String guestSurname, Integer orderID) {
        this.guestID = guestID;
        this.guestPassport = guestPassport;
        this.guestName = guestName;
        this.guestSurname = guestSurname;
        this.orderID = orderID;
    }

    public Integer getGuestID() {
        return guestID;
    }

    public void setGuestID(Integer guestID) {
        this.guestID = guestID;
    }

    public Integer getGuestPassport() {
        return guestPassport;
    }

    public void setGuestPassport(Integer guestPassport) {
        this.guestPassport = guestPassport;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestSurname() {
        return guestSurname;
    }

    public void setGuestSurname(String guestSurname) {
        this.guestSurname = guestSurname;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return getGuestID().equals(guest.getGuestID()) && getGuestPassport().equals(guest.getGuestPassport()) && getGuestName().equals(guest.getGuestName()) && getGuestSurname().equals(guest.getGuestSurname()) && getOrderID().equals(guest.getOrderID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGuestID(), getGuestPassport(), getGuestName(), getGuestSurname(), getOrderID());
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestID=" + guestID +
                ", guestPassport=" + guestPassport +
                ", guestName='" + guestName + '\'' +
                ", guestSurname='" + guestSurname + '\'' +
                ", orderID=" + orderID +
                '}';
    }
}
