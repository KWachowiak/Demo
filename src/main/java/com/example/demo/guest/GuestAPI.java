package com.example.demo.guest;

import java.util.List;
import java.util.UUID;

public interface GuestAPI {

    List<Guest> getAll();

    Guest get(UUID id);

    List<Guest> getByEmail(String email);

    Guest create(GuestDto guestDto);

    void delete(UUID id);
}

