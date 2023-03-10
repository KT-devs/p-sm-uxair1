package ru.uxair.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.flight.entity.Seat;
import ru.uxair.flight.repository.SeatRepository;
import ru.uxair.flight.service.SeatService;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class SeatRestController {
    private final SeatService service;
    private final SeatRepository seatRepository;

    public SeatRestController(SeatService service, SeatRepository seatRepository) {
        this.service = service;
        this.seatRepository = seatRepository;
    }
    @GetMapping("/seat")
    public ResponseEntity<Set<Seat>> getAllSeat() {
        return new ResponseEntity<>(service.getAllSeat(), HttpStatus.OK);
    }
}
