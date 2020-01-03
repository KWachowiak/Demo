package com.example.demo.guest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
class GuestNotFoundException extends RuntimeException {
    GuestNotFoundException(UUID id) {
        super("Guest with Id:["+ id +"] not found");
    }

    GuestNotFoundException(String email) {
        super("No Guests with email" + email + "found");
    }
}