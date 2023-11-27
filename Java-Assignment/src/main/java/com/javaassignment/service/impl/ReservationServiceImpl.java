package com.javaassignment.service.impl;

// ReservationService.java

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaassignment.model.Guest;
import com.javaassignment.model.Reservation;
import com.javaassignment.repository.ReservationRepository;
import com.javaassignment.service.GuestService;
import com.javaassignment.service.ReservationService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private GuestService guestService;

    @Override
    public Reservation saveReservation(Long guestId, Reservation reservation) {
        Guest guest = guestService.getGuestById(guestId);
        reservation.setGuest(guest);
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getReservationsByGuest(Long guestId) {
        Guest guest = guestService.getGuestById(guestId);
        return reservationRepository.findByGuest(guest);
    }

    @Override
    public void updateReservationDates(Long reservationId, LocalDate newStartDate, LocalDate newEndDate) {
        Reservation reservation = getReservationById(reservationId);
        reservation.setStartDate(newStartDate);
        reservation.setEndDate(newEndDate);
        reservationRepository.save(reservation);
    }

    @Override
    public void cancelReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));
    }

    // Other methods as needed
}
