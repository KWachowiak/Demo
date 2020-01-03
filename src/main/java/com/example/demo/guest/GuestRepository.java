package com.example.demo.guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GuestRepository extends CrudRepository<Guest, UUID> {

    List<Guest> findGuestByEmail(String guestEmail);
}
