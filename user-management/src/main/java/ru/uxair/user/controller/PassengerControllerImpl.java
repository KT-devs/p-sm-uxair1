package ru.uxair.user.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.user.entity.Passenger;
import ru.uxair.user.entity.dto.PassengerDTO;
import ru.uxair.user.service.PassengerService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/passenger")
@AllArgsConstructor
public class PassengerControllerImpl implements PassengerController {
    private final PassengerService passengerService;
    private final ModelMapper modelMapper;

    @PostMapping()
    @Override
    public ResponseEntity<HttpStatus> addNewPassenger(@RequestBody @Valid PassengerDTO passengerDTO) {
        passengerService.savePassenger(convertToPassenger(passengerDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<HttpStatus> updatePassengerById(@PathVariable("id") long id,
                                                          @RequestBody @Valid PassengerDTO passengerDTO) {
        passengerService.updatePassenger(id, convertToPassenger(passengerDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable("id") long id) {
        return ResponseEntity.ok(convertToPassengerDTO(passengerService.getPassenger(id)));
    }

    private Passenger convertToPassenger(PassengerDTO passengerDTO) {
        return modelMapper.map(passengerDTO, Passenger.class);
    }

    private PassengerDTO convertToPassengerDTO(Passenger passenger) {
        return modelMapper.map(passenger, PassengerDTO.class);
    }
}
