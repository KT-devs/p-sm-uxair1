package ru.uxair.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Seat;
import ru.uxair.flight.repository.SeatRepository;
import ru.uxair.flight.service.SeatService;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class SeatRestControllerImp implements SeatRestController {
    private final SeatService service;
    private final SeatRepository seatRepository;

    public SeatRestControllerImp(SeatService service, SeatRepository seatRepository) {
        this.service = service;
        this.seatRepository = seatRepository;
    }

    @Override
    @GetMapping("/seat")
    public ResponseEntity<Set<Seat>> getAllSeat() {
        return new ResponseEntity<>(service.getAllSeat(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/seat/free")
    public ResponseEntity<Set<Seat>> getFreeSeat() {
        return new ResponseEntity<>(service.getFreeSeat(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/seat/busy")
    public ResponseEntity<Set<Seat>> getBusySeat() {
        return new ResponseEntity<>(service.getBusySeat(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/seat/reserved")
    public ResponseEntity<Set<Seat>> getReservedSeat() {
        return new ResponseEntity<>(service.getReservedSeat(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/seat/{flight_id}")
    public ResponseEntity<Set<Seat>> getSeatByFlightId(@PathVariable("flight_id") Long id) {
        return new ResponseEntity<>(service.findByFlightId(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/seat/{flight_id}/{category_id}")
    public ResponseEntity<Set<Seat>> getSeatByFlightId(@PathVariable("flight_id") Long flight_id, @PathVariable("category_id") Long category_id) {
        return new ResponseEntity<>(service.findByFlightIdAndCategoryId(flight_id, category_id), HttpStatus.OK);
    }

    @Override
    @PostMapping("/seat")
    public ResponseEntity<HttpStatus> saveNewSeat(@RequestBody Seat seat) {
        service.createSeat(seat);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @PatchMapping("/seat/{id}")
    public ResponseEntity<HttpStatus> updateSeat(@RequestBody Seat seat) {
        service.updateSeat(seat);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/seat/{id}")
    public ResponseEntity<HttpStatus> deleteSeat(@PathVariable("id") Long id) {
        service.deleteSeat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
