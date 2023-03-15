package ru.uxair.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.uxair.user.entity.dto.PassengerDTO;

public interface PassengerController {
    ResponseEntity<HttpStatus> addNewPassenger(PassengerDTO passengerDTO);

    ResponseEntity<HttpStatus> updatePassengerById(long id, PassengerDTO passengerDTO);

    ResponseEntity<PassengerDTO> getPassengerById(long id);
}
