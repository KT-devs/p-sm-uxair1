package ru.uxair.flight.controller.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.controller.SeatRestController;
import ru.uxair.flight.entity.Seat;
import ru.uxair.flight.entity.dto.SeatDto;
import ru.uxair.flight.repository.SeatRepository;
import ru.uxair.flight.service.SeatService;
import ru.uxair.flight.util.mapper.SeatMapper;
import ru.uxair.flight.util.validator.SeatValidator;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class SeatRestControllerImp implements SeatRestController {
    private final SeatService service;
    private final SeatRepository seatRepository;
    private final SeatValidator seatValidator;
    private final SeatMapper seatMapper;

    @Override
    @GetMapping("/seat")
    public ResponseEntity<Set<SeatDto>> getAllSeat() {
        final Set<SeatDto> seats = seatMapper.convertToSetSeatDto(service.getAllSeat());
        return seats != null && seats.isEmpty()
                ? new ResponseEntity<>(seats, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping("/seat/free")
    public ResponseEntity<Set<SeatDto>> getFreeSeat() {
        final Set<SeatDto> freeSeats = seatMapper.convertToSetSeatDto(service.getFreeSeat());
        return freeSeats != null && freeSeats.isEmpty()
                ? new ResponseEntity<>(freeSeats, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping("/seat/busy")
    public ResponseEntity<Set<SeatDto>> getBusySeat() {
        final Set<SeatDto> busySeats =seatMapper.convertToSetSeatDto(service.getBusySeat());
        return busySeats != null && busySeats.isEmpty()
                ? new ResponseEntity<>(busySeats, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping("/seat/reserved")
    public ResponseEntity<Set<SeatDto>> getReservedSeat() {
        final Set<SeatDto> reversedSeats =seatMapper.convertToSetSeatDto(service.getReservedSeat());
        return reversedSeats != null && reversedSeats.isEmpty()
                ? new ResponseEntity<>(reversedSeats, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping("/seat/{flight_id}")
    public ResponseEntity<Set<SeatDto>> getSeatByFlightId(@PathVariable("flight_id") Long id) {
        final Set<SeatDto> seatsByFlightId =seatMapper.convertToSetSeatDto(service.findByFlightId(id));
        return seatsByFlightId != null && seatsByFlightId.isEmpty()
                ? new ResponseEntity<>(seatsByFlightId, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @Override
    @GetMapping("/seat/{flight_id}/{category_id}")
    public ResponseEntity<Set<SeatDto>> getSeatByFlightId(@PathVariable("flight_id") Long flight_id,
                                                       @PathVariable("category_id") Long category_id) {
        final Set<SeatDto> seatsByFlightIdAndCategoryId =seatMapper.convertToSetSeatDto(service.findByFlightIdAndCategoryId(flight_id, category_id));
        return seatsByFlightIdAndCategoryId != null && seatsByFlightIdAndCategoryId.isEmpty()
                ? new ResponseEntity<>(seatsByFlightIdAndCategoryId, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @PostMapping("/seat")
    public ResponseEntity<HttpStatus> saveNewSeat(@RequestBody SeatDto seatDto,
                                                  BindingResult bindingResult) {
        seatValidator.validate(seatDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        service.createSeat(seatMapper.convertToSeat(seatDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @PatchMapping("/seat/{id}")
    public ResponseEntity<HttpStatus> updateSeat(@RequestBody SeatDto seatDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        service.updateSeat(seatMapper.convertToSeat(seatDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/seat/{id}")
    public ResponseEntity<HttpStatus> deleteSeat(@PathVariable("id") Long id) {
        service.deleteSeat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
