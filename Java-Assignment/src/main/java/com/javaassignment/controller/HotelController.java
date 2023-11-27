package com.javaassignment.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaassignment.model.Guest;
import com.javaassignment.model.Reservation;
import com.javaassignment.service.GuestService;
import com.javaassignment.service.ReservationService;

// HotelController.java
@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private GuestService guestService;

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/guest")
    public Guest createGuest(@RequestBody Guest guest) {
        return guestService.saveGuest(guest);
    }

    @PostMapping("/reservation/{guestId}")
    public Reservation createReservation(@PathVariable Long guestId, @RequestBody Reservation reservation) {
        return reservationService.saveReservation(guestId, reservation);
    }

    @GetMapping("/reservations/{guestId}")
    public List<Reservation> getReservationsByGuest(@PathVariable Long guestId) {
        return reservationService.getReservationsByGuest(guestId);
    }

    @PutMapping("/reservation/{reservationId}")
    public void updateReservationDates(
            @PathVariable Long reservationId,
            @RequestParam LocalDate newStartDate,
            @RequestParam LocalDate newEndDate) {
        reservationService.updateReservationDates(reservationId, newStartDate, newEndDate);
    }

    @DeleteMapping("/reservation/{reservationId}")
    public void cancelReservation(@PathVariable Long reservationId) {
        reservationService.cancelReservation(reservationId);
    }

    // Other methods for updating and canceling reservations
}
