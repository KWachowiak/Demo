package com.example.demo.guest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Guest {

    @Id
    private final UUID id = UUID.randomUUID();

    private String name;

    private String email;

    private boolean goldMember;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;
}