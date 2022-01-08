package com.senla.hoteladmin;

import com.senla.hoteladmin.controller.AdminController;
import com.senla.hoteladmin.dao.*;
//import com.senla.hoteladmin.controller.AdminController;
import com.senla.hoteladmin.entity.*;
import com.senla.hoteladmin.service.*;
import com.senla.hoteladmin.util.DbConnect;
import com.senla.hoteladmin.util.IDbConnect;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws SQLException {
        IDbConnect dbConnect = new DbConnect();

//        IAdditionalServiceRepo additionalServiceDaoStorage = new AdditionalServiceDaoImpl();
//        IBookingOrderRepo bookingOrderDaoStorage = new BookingOrderDaoImpl();
        IGuestRepo guestDaoStorage = new GuestDaoImpl(dbConnect);
        IRoomRepo roomDaoStorage = new RoomDaoImpl(dbConnect);

//        IAdditionalServiceService additionalServiceServiceMain =
//                new AdditionalServiceService(additionalServiceDaoStorage);
//        IBookingOrderService bookingOrderServiceMain = new BookingOrderService(bookingOrderDaoStorage);
//        IGuestService guestServiceMain = new GuestService(guestDaoStorage);
        IRoomService roomServiceMain = new RoomService(dbConnect);

        AdminController adminController = new AdminController(guestDaoStorage, roomDaoStorage);

        Guest guest1 = new Guest
                (1, 254554, "Ivan", "Ivanov", 1);
        guestDaoStorage.saveGuest(guest1);

//        adminController.createNewRoom(4, RoomType.STARS_3, 2, 3500);
        roomDaoStorage.getAllRooms().forEach(System.out::println);
//        roomServiceMain.getHotelRoomsSortedByRoomPlaces().forEach(System.out::println);

//        Room room1 = new Room();
//        room1.setRoomNumber(1);
//        room1.setRoomType(RoomType.STARS_3);
//        room1.setRoomPlaces(5);
//        room1.setRoomPrice(6000);
//        room1.setRoomStatus(RoomStatus.EMPTY);
//        roomDaoStorage.saveRoom(room1);
//
//        Room room2 = new Room();
//        room2.setRoomNumber(2);
//        room2.setRoomType(RoomType.STARS_2);
//        room2.setRoomPlaces(4);
//        room2.setRoomPrice(2700);
//        room2.setRoomStatus(RoomStatus.EMPTY);
//        roomDaoStorage.saveRoom(room2);
//
//        Room room3 = new Room();
//        room3.setRoomNumber(3);
//        room3.setRoomType(RoomType.STARS_2);
//        room3.setRoomPlaces(2);
//        room3.setRoomPrice(2000);
//        room3.setRoomStatus(RoomStatus.EMPTY);
//        roomDaoStorage.saveRoom(room3);

//        roomDaoStorage.deleteRoom(1);
//        roomDaoStorage.deleteRoom(2);

//        controller.createNewRoom(1, RoomType.STARS_3, 5, 6000);
//        adminController.createNewRoom(2, 2, RoomType.STARS_2, 4, 2700);
//        adminController.createNewRoom(3, 3, RoomType.STARS_2, 2, 2000);
//        adminController.createNewRoom(4, 4, RoomType.STARS_3, 2, 3500);
//        adminController.createNewRoom(5, 5, RoomType.STARS_4, 3, 5600);

//        adminController.createNewAdditionalService(1, "Cleaning", 600);
//        adminController.createNewAdditionalService(2, "Food delivery", 400);
//        adminController.createNewAdditionalService(3, "Washing clothes", 100);
//        adminController.createNewAdditionalService(4, "Cable TV", 100);
//        adminController.createNewAdditionalService(5, "Safe", 100);

//        adminController.createNewOrder(1,
//                LocalDate.of(2021, 12, 31),
//                LocalDate.of(2022, 01, 03),
//                adminController.getRoomByNumber(2),
//                adminController.createOrderAddServicesList(
//                        adminController.getAdditionalServiceByID(2),
//                        adminController.getAdditionalServiceByID(3),
//                        adminController.getAdditionalServiceByID(4)),
//                adminController.createOrderGuestsList(
//                        new Guest(1, 254554, "Ivan", "Ivanov"),
//                        new Guest(2, 654123, "Petr", "Petrov"),
//                        new Guest(3, 258345, "Sergey", "Sergov")),
//                OrderStatus.BOOKING);
//
//        adminController.createNewOrder(2,
//                LocalDate.of(2021, 12, 31),
//                LocalDate.of(2022, 01, 05),
//                adminController.getRoomByNumber(3),
//                adminController.createOrderAddServicesList(
//                        adminController.getAdditionalServiceByID(1),
//                        adminController.getAdditionalServiceByID(5)),
//                adminController.createOrderGuestsList(
//                        new Guest(4, 5461233, "Anna", "Annavna"),
//                        new Guest(5, 48516532, "Tana", "Tanavna")),
//                OrderStatus.BOOKING);
//
//        adminController.createNewOrder(3,
//                LocalDate.of(2022, 01, 02),
//                LocalDate.of(2022, 01, 06),
//                adminController.getRoomByNumber(5),
//                adminController.createOrderAddServicesList(
//                        adminController.getAdditionalServiceByID(2),
//                        adminController.getAdditionalServiceByID(3),
//                        adminController.getAdditionalServiceByID(4),
//                        adminController.getAdditionalServiceByID(5)),
//                adminController.createOrderGuestsList(
//                        new Guest(6, 5454161, "Sema", "Semaov"),
//                        new Guest(7, 544845, "Petr", "Semak"),
//                        new Guest(8, 6546464, "Sergey", "Orlov")),
//                OrderStatus.BOOKING);
//
//        adminController.createNewOrder(4,
//                LocalDate.of(2022, 01, 01),
//                LocalDate.of(2022, 01, 05),
//                adminController.getRoomByNumber(4),
//                adminController.createOrderAddServicesList(
//                        adminController.getAdditionalServiceByID(1),
//                        adminController.getAdditionalServiceByID(3)),
//                adminController.createOrderGuestsList(
//                        new Guest(9, 26544565, "Mark", "Orlovski")),
//                OrderStatus.BOOKING);
//
//
//        adminController.createNewOrder(5,
//                LocalDate.of(2021, 12, 22),
//                LocalDate.of(2021, 12, 24),
//                adminController.getRoomByNumber(2),
//                adminController.createOrderAddServicesList(
//                        adminController.getAdditionalServiceByID(2),
//                        adminController.getAdditionalServiceByID(4)),
//                adminController.createOrderGuestsList
//                        (new Guest(10, 5653232, "Anna", "Vannh")),
//                OrderStatus.BOOKING);
//
//        adminController.createNewOrder(6,
//                LocalDate.of(2021, 12, 24),
//                LocalDate.of(2021, 12, 25),
//                adminController.getRoomByNumber(2),
//                adminController.createOrderAddServicesList(
//                        adminController.getAdditionalServiceByID(1),
//                        adminController.getAdditionalServiceByID(5)),
//                adminController.createOrderGuestsList(
//                        new Guest(11, 5486331, "Anna", "Are"),
//                        new Guest(12, 212165498, "Vita", "Atyh")),
//                OrderStatus.BOOKING);
//
//        adminController.createNewOrder(7,
//                LocalDate.of(2021, 12, 26),
//                LocalDate.of(2021, 12, 29),
//                adminController.getRoomByNumber(2),
//                adminController.createOrderAddServicesList(
//                        adminController.getAdditionalServiceByID(2),
//                        adminController.getAdditionalServiceByID(3)),
//                adminController.createOrderGuestsList(
//                        new Guest(13, 3256564, "Noi", "Kiut")),
//                OrderStatus.BOOKING);
//
//        adminController.createNewOrder(8,
//                LocalDate.of(2021, 12, 20),
//                LocalDate.of(2021, 12, 23),
//                adminController.getRoomByNumber(2),
//                adminController.createOrderAddServicesList(
//                        adminController.getAdditionalServiceByID(1),
//                        adminController.getAdditionalServiceByID(2)),
//                adminController.createOrderGuestsList(
//                        new Guest(14, 8955512, "Mao", "Dzer")),
//                OrderStatus.BOOKING);



        /* Check in to the room */
//        adminController.checkInOrder(1);
//        adminController.checkInOrder(2);
//        adminController.checkInOrder(3);
//        adminController.checkInOrder(4);
//        adminController.checkInOrder(5);
//        adminController.checkInOrder(6);
//        adminController.checkInOrder(7);
//        adminController.checkInOrder(8);
//
//        List<Guest> guests = bookingOrderDaoStorage.getAll().stream()
//                .map(bookingOrder -> bookingOrder.getOrderedGuests())
//                .flatMap(Collection::stream).collect(Collectors.toList());
//        System.out.println(guests);

//
//        /* Check out the room */
//        adminController.checkOutOrder(5);
//        adminController.checkOutOrder(6);
//        adminController.checkOutOrder(7);
//        adminController.checkOutOrder(8);
//
//        /* Change the status of the room to being repaired */
//        adminController.setRoomStatusAsOnRepair(3);
//        adminController.setRoomStatusAsEmpty(3);
//
//        /* Set a new room price */
//        adminController.setNewPriceRoom(3, 4300);
//
//        /* Add a room or service was done at the beginning */
//
//        /* List of rooms (sort by price, capacity, star rating) */
//        System.out.println
//                ("List of rooms (sort by price, capacity, star rating)");
//        adminController.printList(roomServiceMain.getHotelRoomsSortedByRoomPrice());
//        System.out.println();
//        adminController.printList(roomServiceMain.getHotelRoomsSortedByRoomPlaces());
//        System.out.println();
//        adminController.printList(roomServiceMain.getHotelRoomsSortedByRoomType());
//        System.out.println();
//
//        /* List of available rooms (sort by price, capacity, number of stars)*/
//        System.out.println
//                ("List of available rooms (sort by price, capacity, number of stars)");
//        adminController.printList(roomServiceMain.getEmptyHotelRoomsSortedByRoomPrice());
//        System.out.println();
//        adminController.printList(roomServiceMain.getEmptyHotelRoomsSortedByRoomPlaces());
//        System.out.println();
//        adminController.printList(roomServiceMain.getEmptyHotelRoomsSortedByRoomType());
//        System.out.println();
//
//        /* List of guests and their rooms (sort by alphabet, release date) */
//        System.out.println
//                ("List of guests and their rooms (sort by alphabet, release date)");
//        adminController.printList(adminController.getListGuestsAndTheirRoomsSortedByRoom());
//        System.out.println();
//        adminController.printList(adminController.getListGuestsAndTheirRoomsSortedByCheckOutDays());
//        System.out.println();
//
//        /* Total number of free rooms */
//        System.out.println("Total number of free rooms");
//        System.out.println(roomServiceMain.getNumberEmptyHotelRooms());
//        System.out.println();
//
//        /* Total number of guests */
//        System.out.println("Total number of guests");
//        System.out.println(guestServiceMain.getNumberGuestsHotel());
//        System.out.println();
//
//        /* List of rooms that will be available by a certain date in the future */
//        System.out.println("List of rooms that will be available by a certain date in the future");
//        adminController.printList(adminController.
//                getEmptyHotelRoomsListOnDate(LocalDate.of(2022, 01, 05)));
//        System.out.println();
//
//        /* The amount of payment for the room to be paid by the guest */
//        System.out.println("The amount of payment for the room to be paid by the guest");
//        System.out.println(adminController.getOrderPrice(2));
//        System.out.println(adminController.getOrderPrice(3));
//        System.out.println(adminController.getOrderPrice(4));
//        System.out.println();
//
//        /* View the last 3 guests of the room and the dates of their stay */
//        System.out.println("View the last 3 guests of the room and the dates of their stay");
//        adminController.printList(bookingOrderServiceMain.getLastThreeGuestsRoom(2));
//        System.out.println();
//
//        /* View the list of services provided by the guest and their prices (sort by price, by date) */
//        System.out.println
//                ("View the list of services provided by the guest and their prices (sort by price, by date)");
//        adminController.printList
//                (bookingOrderServiceMain.getListAdditionalServiceOfGuestSortedByPrice(7));
//        System.out.println();
//
//        /* Prices of services and rooms (sort by section, price) */
//        System.out.println("Prices of services and rooms (sort by section, price)");
//        adminController.printList(roomServiceMain.getHotelRoomsSortedByRoomPrice());
//        adminController.printList(additionalServiceServiceMain.getListAdditionalServicesSortedByPrice());
//        System.out.println();
//
//        /* View individual room details */
//        System.out.println("View individual room details");
//        System.out.println(roomServiceMain.showRoomDetails(4));
    }
}
