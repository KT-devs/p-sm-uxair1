package ru.uxair.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.uxair.flight.entity.Seat;

import java.util.Set;

public interface SeatRestController {
    ResponseEntity<Set<Seat>> getAllSeat();
    ResponseEntity<Set<Seat>> getFreeSeat();
    ResponseEntity<Set<Seat>> getBusySeat();
    ResponseEntity<Set<Seat>> getReservedSeat();
    ResponseEntity<Set<Seat>> getSeatByFlightId(@PathVariable("flight_id") Long id);
    ResponseEntity<Set<Seat>> getSeatByFlightId(@PathVariable("flight_id") Long flight_id,
                                                @PathVariable("category_id") Long category_id);
    ResponseEntity<HttpStatus> saveNewSeat(@RequestBody Seat seat);
    ResponseEntity<HttpStatus> updateSeat(@RequestBody Seat seat);
    ResponseEntity<HttpStatus> deleteSeat(@PathVariable("id") Long id);
}
