package com.example.demo.guest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class GuestService implements GuestAPI {

    private final GuestRepository guestRepository;

    @Override
    public List<Guest> getAll() {
        return StreamSupport.stream(guestRepository.findAll().spliterator(), true)
                .collect(Collectors.toList());
    }

    @Override
    public Guest get(UUID id) {
        return guestRepository.findById(id)
                .orElseThrow(() -> new GuestNotFoundException(id));
    }

    @Override
    public List<Guest> getByEmail(String email) {
        List<Guest> guests = guestRepository.findGuestByEmail(email);

        if (guests.isEmpty()) {
            throw new GuestNotFoundException(email);
        }

        return guests;
    }

    @Override
    public Guest create(GuestDto guestDto) {
        return guestRepository.save(Guest.builder()
                .name(guestDto.getName())
                .email(guestDto.getEmail())
                .goldMember(guestDto.isGoldMember())
                .checkInDate(guestDto.getCheckInDate())
                .checkOutDate(guestDto.getCheckOutDate())
                .build());
    }

    @Override
    public void delete(UUID id) {
        Guest guestToDelete = this.get(id);
        guestRepository.delete(guestToDelete);
    }
}
