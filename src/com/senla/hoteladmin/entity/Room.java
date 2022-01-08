package com.senla.hoteladmin.entity;

import java.util.Objects;

public class Room {
    private Integer roomNumber;
    private RoomType roomType;
    private Integer roomPlaces;
    private Integer roomPrice;
    private RoomStatus roomStatus;

    public Room() {
    }

    public Room(Integer roomNumber, RoomType roomType, Integer roomPlaces, Integer roomPrice) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomPlaces = roomPlaces;
        this.roomPrice = roomPrice;
        this.roomStatus = RoomStatus.EMPTY;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Integer getRoomPlaces() {
        return roomPlaces;
    }

    public void setRoomPlaces(Integer roomPlaces) {
        this.roomPlaces = roomPlaces;
    }

    public Integer getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Integer roomPrice) {
        this.roomPrice = roomPrice;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return getRoomNumber().equals(room.getRoomNumber()) && getRoomType() == room.getRoomType() && getRoomPlaces().equals(room.getRoomPlaces()) && getRoomPrice().equals(room.getRoomPrice()) && getRoomStatus() == room.getRoomStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomNumber(), getRoomType(), getRoomPlaces(), getRoomPrice(), getRoomStatus());
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType=" + roomType +
                ", roomPlaces=" + roomPlaces +
                ", roomPrice=" + roomPrice +
                ", roomStatus=" + roomStatus +
                '}';
    }
}
