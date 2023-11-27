package com.javaassignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaassignment.model.Guest;
import com.javaassignment.model.Reservation;

// ReservationRepository.java
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByGuest(Guest guest);
}
