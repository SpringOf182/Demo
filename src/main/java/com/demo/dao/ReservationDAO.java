package com.demo.dao;

import com.demo.pojo.Reservation;

import java.util.List;

public interface ReservationDAO {
    public Boolean reserveBook(Integer bookId);
    public List<Reservation> reservationList(Integer userId);
    public Boolean cancelReservation(Integer reservationID);
}
