package com.javaassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaassignment.model.Guest;

// GuestRepository.java
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
