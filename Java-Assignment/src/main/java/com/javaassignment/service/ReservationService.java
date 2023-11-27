package com.javaassignment.service;

import java.time.LocalDate;
import java.util.List;

import com.javaassignment.model.Reservation;

public interface ReservationService {
    public Reservation saveReservation(Long guestId, Reservation reservation);

    public List<Reservation> getReservationsByGuest(Long guestId);

    public void updateReservationDates(Long reservationId, LocalDate newStartDate, LocalDate newEndDate);

    public void cancelReservation(Long reservationId);

    public Reservation getReservationById(Long id);
}
