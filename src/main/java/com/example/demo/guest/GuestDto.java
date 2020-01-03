package com.example.demo.guest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class GuestDto {

    private UUID id;

    @NotNull
    private String name;

    @Email
    @NotNull
    private String email;

    @NotNull
    private boolean goldMember;

    @NotNull
    private LocalDate checkInDate;

    @NotNull
    private LocalDate checkOutDate;

    static GuestDto from(Guest guest) {
        return GuestDto.builder()
                .id(guest.getId())
                .name(guest.getName())
                .email(guest.getEmail())
                .goldMember(guest.isGoldMember())
                .checkInDate(guest.getCheckInDate())
                .checkOutDate(guest.getCheckOutDate())
                .build();
    }
}
