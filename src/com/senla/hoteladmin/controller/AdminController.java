package com.senla.hoteladmin.controller;

import com.senla.hoteladmin.service.IAdditionalServiceService;
import com.senla.hoteladmin.service.IBookingOrderService;
import com.senla.hoteladmin.service.IGuestService;
import com.senla.hoteladmin.service.IRoomService;

import java.sql.SQLException;

public class AdminController {

    private final IAdditionalServiceService additionalServiceService;
    private final IBookingOrderService bookingOrderService;
    private final IGuestService guestService;
    private final IRoomService roomService;

    public AdminController(IAdditionalServiceService additionalServiceService,
                           IBookingOrderService bookingOrderService,
                           IGuestService guestService, IRoomService roomService) {
        this.additionalServiceService = additionalServiceService;
        this.bookingOrderService = bookingOrderService;
        this.guestService = guestService;
        this.roomService = roomService;
    }

    public void checkInOrder(Integer orderID) throws SQLException {
        bookingOrderService.setBookingOrderChekInStatus(orderID);
        roomService.setRoomChekInStatus(bookingOrderService.getBookingOrder(orderID).getOrderedRoom());
    }

    public void checkOutOrder(Integer orderID) throws SQLException {
        bookingOrderService.setBookingOrderChekOutStatus(orderID);
        roomService.setRoomEmptyStatus(bookingOrderService.getBookingOrder(orderID).getOrderedRoom());
    }

    //
//    public AdminController(IAdditionalServiceService additionalServiceService,
//                           IBookingOrderService bookingOrderService,
//                           IGuestService guestService,
//                           IRoomService roomService) {
//        this.additionalServiceService = additionalServiceService;
//        this.bookingOrderService = bookingOrderService;
//        this.guestService = guestService;
//        this.roomService = roomService;
//    }
//
//    public void createNewRoom(Integer roomNumber, RoomType roomType, Integer roomPlaces,
//                              Integer roomPrice) throws SQLException {
//        Room room = new Room(roomNumber, roomType, roomPlaces, roomPrice);
//        roomRepo.saveRoom(room);
//    }
//
//    public void deleteRoom(Integer roomNumber) {
//        for (Room room : roomService.getRoomList()) {
//            if (room.getRoomNumber().equals(roomNumber)) {
//                roomService.deleteRoom(room);
//            }
//        }
//    }
//
//    public Room getRoomByNumber(Integer roomNumber) {
//        return roomService.getRoomByNumber(roomNumber);
//    }
//
//    public List<Room> getRoomsList() {
//        return roomService.getRoomList();
//    }
//
//    public void createNewAdditionalService(
//            Integer serviceID,
//            String serviceName,
//            Integer servicePrice) {
//        AdditionalService service = new AdditionalService(serviceID, serviceName, servicePrice);
//        additionalServiceService.setNewAdditionalService(service);
//    }
//
//    public void deleteAdditionalService(Integer serviceID) {
//        additionalServiceService.deleteAdditionalService
//                (additionalServiceService.getListAdditionalServices()
//                        .stream()
//                        .filter(additionalService -> additionalService.getServiceID().equals(serviceID))
//                        .findFirst()
//                        .orElse(null));
//    }
//
//    public AdditionalService getAdditionalServiceByID(Integer serviceID) {
//        return additionalServiceService.getAdditionalServiceByID(serviceID);
//    }
//
//    public List<Guest> createOrderGuestsList(Guest... guests) {
//        List<Guest> hotelGuestsList = new ArrayList<>();
//        hotelGuestsList.addAll(Arrays.asList(guests));
//        return hotelGuestsList;
//    }
//
//    public <T> StringBuilder listAsStr (List<T> list) {
//        StringBuilder s = new StringBuilder();
//        list.forEach(s::append);
//        return s;
//    }
//
//    public List<AdditionalService> createOrderAddServicesList(AdditionalService... additionalServices) {
//        List<AdditionalService> hotelAddServicesList = new ArrayList<>();
//        hotelAddServicesList.addAll(Arrays.asList(additionalServices));
//        return hotelAddServicesList;
//    }
//
//    public void createNewOrder(
//            Integer orderID,
//            LocalDate orderCheckInDate,
//            LocalDate orderCheckOutDate,
//            Room orderedHotelRoom,
//            List<AdditionalService> orderedAdditionalServices,
//            List<Guest> orderHotelGuests,
//            OrderStatus orderStatus) {
//        BookingOrder bookingOrder = new BookingOrder(orderID, orderCheckInDate,
//                orderCheckOutDate, orderedHotelRoom, orderedAdditionalServices, orderHotelGuests,
//                orderStatus);
//        bookingOrderService.saveNewBookingOrder(bookingOrder);
//    }
//
//    public List<Room> getEmptyHotelRoomsListOnDate(LocalDate date) {
//        List<Room> roomsBusy = new ArrayList<>();
//        for (BookingOrder bookingOrder : bookingOrderService.getListBookingOrders()) {
//            if ((date.isAfter(bookingOrder.getOrderCheckInDate().minusDays(1))
//                    && date.isBefore(bookingOrder.getOrderCheckOutDate().plusDays(1)))) {
//                roomsBusy.add(bookingOrder.getOrderedRoom());
//            }
//        }
//        List<Room> EmptyHotelRoomsListOnDate = new ArrayList<>(roomService.getRoomList());
//        EmptyHotelRoomsListOnDate.removeAll(roomsBusy);
//        return EmptyHotelRoomsListOnDate;
//    }
//

//
//    public void checkOutOrder(Integer orderID) {
//        for (BookingOrder order : bookingOrderService.getListBookingOrders()) {
//            if (order.getOrderID().equals(orderID)) {
//                /* Можно добавить проверку даты конца брони на текущую дату
//               if (order.getOrderCheckOutDate().isEqual(LocalDate.now())) { */
//                order.setOrderStatus(OrderStatus.CHECK_OUT);
//                for (Guest guest : order.getOrderedGuests()) {
//                    guestService.removeGuestFromStorage(guest);
//                }
//                for (Room room : roomService.getRoomList()) {
//                    if (room.getRoomNumber().equals(order.getOrderedRoom().getRoomNumber())) {
//                        room.setRoomStatus(RoomStatus.EMPTY);
//                    }
//                }
////                }
//            }
//        }
//    }
//
//    public void setRoomStatusAsOnRepair(Integer roomNumber) {
//        for (Room rooms : roomService.getRoomList()) {
//            if (rooms.getRoomNumber().equals(roomNumber)
//                    && !rooms.getRoomStatus().equals(RoomStatus.ON_REPAIR)
//                    && !rooms.getRoomStatus().equals(RoomStatus.BUSY)) {
//                rooms.setRoomStatus(RoomStatus.ON_REPAIR);
//            }
//        }
//    }
//
//    public void setRoomStatusAsEmpty(Integer roomNumber) {
//        for (Room rooms : roomService.getRoomList()) {
//            if (rooms.getRoomNumber().equals(roomNumber)
//                    && rooms.getRoomStatus().equals(RoomStatus.ON_REPAIR)
//                    && !rooms.getRoomStatus().equals(RoomStatus.BUSY)) {
//                rooms.setRoomStatus(RoomStatus.EMPTY);
//            }
//        }
//    }
//
//    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByRoom() {
//        return bookingOrderService.getListGuestsAndTheirRoomsSortedByRoom();
//    }
//
//    public List<BookingOrder> getListGuestsAndTheirRoomsSortedByCheckOutDays() {
//        return bookingOrderService.getListGuestsAndTheirRoomsSortedByCheckOutDays();
//    }
//
//    public Long getOrderPrice(Integer orderID) {
//        Long res = null;
//        for (BookingOrder order : bookingOrderService.getListBookingOrders()) {
//            if (order.getOrderID().equals(orderID)) {
//                res = ((order.getOrderedAdServ()
//                        .stream()
//                        .mapToLong(AdditionalService::getServicePrice)
//                        .sum()) + (order.getOrderedRoom().getRoomPrice())) *
//                        order.getOrderCheckOutDate().
//                                until(order.getOrderCheckInDate(), ChronoUnit.DAYS);
//            }
//        }
//        return res;
//    }
//
//    public <T> void printList(List<T> list) {
//        list.forEach(System.out::println);
//    }
//
//    public void setNewPriceRoom(Integer roomNumber, Integer priceRoom) {
//        roomService.setNewPriceRoom(roomNumber, priceRoom);
//    }
//
//    List<BookingOrder> getListBookingOrders() {
//        return bookingOrderService.getListBookingOrders();
//    }
}
