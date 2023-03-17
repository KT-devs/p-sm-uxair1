package ru.uxair.user.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.user.entity.Passenger;
import ru.uxair.user.entity.dto.PassengerDTO;
import ru.uxair.user.service.PassengerService;

@RestController
@AllArgsConstructor
public class PassengerControllerImpl implements PassengerController {
    private final PassengerService passengerService;
    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<HttpStatus> addNewPassenger(PassengerDTO passengerDTO) {
        passengerService.savePassenger(convertToPassenger(passengerDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updatePassengerById(long id,
                                                          PassengerDTO passengerDTO) {
        passengerService.updatePassenger(id, convertToPassenger(passengerDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PassengerDTO> getPassengerById(long id) {
        return ResponseEntity.ok(convertToPassengerDTO(passengerService.getPassenger(id)));
    }

    private Passenger convertToPassenger(PassengerDTO passengerDTO) {
        return modelMapper.map(passengerDTO, Passenger.class);
    }

    private PassengerDTO convertToPassengerDTO(Passenger passenger) {
        return modelMapper.map(passenger, PassengerDTO.class);
    }
}
