package com.javaassignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaassignment.model.Guest;
import com.javaassignment.repository.GuestRepository;
import com.javaassignment.service.GuestService;

import jakarta.persistence.EntityNotFoundException;

// GuestService.java
@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public Guest saveGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public Guest getGuestById(Long id) {
        return guestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Guest not found with id: " + id));
    }


    // Other methods as needed
}
