package ru.uxair.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.entity.Seat;
import ru.uxair.flight.repository.SeatRepository;
import ru.uxair.flight.service.SeatService;
import ru.uxair.flight.util.validator.SeatValidator;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class SeatRestControllerImp implements SeatRestController {
    private final SeatService service;
    private final SeatRepository seatRepository;
    private final SeatValidator seatValidator;

    public SeatRestControllerImp(SeatService service, SeatRepository seatRepository, SeatValidator seatValidator) {
        this.service = service;
        this.seatRepository = seatRepository;
        this.seatValidator = seatValidator;
    }

    @Override
    @GetMapping("/seat")
    public ResponseEntity<Set<Seat>> getAllSeat() {
        final Set<Seat> seats = service.getAllSeat();
        return seats != null && seats.isEmpty()
                ? new ResponseEntity<>(seats, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping("/seat/free")
    public ResponseEntity<Set<Seat>> getFreeSeat() {
        final Set<Seat> freeSeats = service.getFreeSeat();
        return freeSeats != null && freeSeats.isEmpty()
                ? new ResponseEntity<>(freeSeats, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping("/seat/busy")
    public ResponseEntity<Set<Seat>> getBusySeat() {
        final Set<Seat> busySeats = service.getBusySeat();
        return busySeats != null && busySeats.isEmpty()
                ? new ResponseEntity<>(busySeats, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping("/seat/reserved")
    public ResponseEntity<Set<Seat>> getReservedSeat() {
        final Set<Seat> reversedSeats = service.getReservedSeat();
        return reversedSeats != null && reversedSeats.isEmpty()
                ? new ResponseEntity<>(reversedSeats, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping("/seat/{flight_id}")
    public ResponseEntity<Set<Seat>> getSeatByFlightId(@PathVariable("flight_id") Long id) {
        final Set<Seat> seatsByFlightId = service.findByFlightId(id);
        return seatsByFlightId != null && seatsByFlightId.isEmpty()
                ? new ResponseEntity<>(seatsByFlightId, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @Override
    @GetMapping("/seat/{flight_id}/{category_id}")
    public ResponseEntity<Set<Seat>> getSeatByFlightId(@PathVariable("flight_id") Long flight_id,
                                                       @PathVariable("category_id") Long category_id) {
        final Set<Seat> seatsByFlightIdAndCategoryId = service.findByFlightIdAndCategoryId(flight_id, category_id);
        return seatsByFlightIdAndCategoryId != null && seatsByFlightIdAndCategoryId.isEmpty()
                ? new ResponseEntity<>(seatsByFlightIdAndCategoryId, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @PostMapping("/seat")
    public ResponseEntity<HttpStatus> saveNewSeat(@RequestBody Seat seat,
                                                  BindingResult bindingResult) {
        seatValidator.validate(seat, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        service.createSeat(seat);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @PatchMapping("/seat/{id}")
    public ResponseEntity<HttpStatus> updateSeat(@RequestBody Seat seat, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
