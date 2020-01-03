package com.example.demo.guest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("guest")
@RequiredArgsConstructor
public class GuestController {

    private final GuestAPI guestAPI;

    @GetMapping
    public List<GuestDto> getAll() {
        return guestAPI.getAll().stream()
                .map(GuestDto::from)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public GuestDto get(@PathVariable UUID id) {
        return GuestDto.from(guestAPI.get(id));
    }

    @GetMapping("email")
    public List<GuestDto> getAllByEmail(@RequestParam String email) {
        return guestAPI.getByEmail(email).stream()
                .map(GuestDto::from)
                .collect(Collectors.toList());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GuestDto create(@RequestBody GuestDto guestDto) {
        return GuestDto.from(guestAPI.create(guestDto));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        guestAPI.delete(id);
    }
}