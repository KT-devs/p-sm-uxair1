package ru.uxair.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.uxair.user.entity.dto.PassengerDTO;

@Tag(name = "Passenger", description = "Methods for passenger operation")
public interface PassengerController {
    @Operation(summary = "Method for add passenger")
    ResponseEntity<HttpStatus> addNewPassenger(PassengerDTO passengerDTO);

    @Operation(summary = "Method for update passenger by id")
    ResponseEntity<HttpStatus> updatePassengerById(
            @Parameter(description = "Unique identifier of passenger") long id, PassengerDTO passengerDTO);

    @Operation(summary = "Method for get passenger by id")
    ResponseEntity<PassengerDTO> getPassengerById(@Parameter(description = "Unique identifier of passenger") long id);
}
