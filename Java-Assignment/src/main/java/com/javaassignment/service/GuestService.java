package com.javaassignment.service;

import com.javaassignment.model.Guest;

public interface GuestService {

    public Guest saveGuest(Guest guest);

    public Guest getGuestById(Long id);
}
