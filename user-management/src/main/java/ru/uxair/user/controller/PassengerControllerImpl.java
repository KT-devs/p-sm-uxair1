package ru.uxair.user.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.user.entity.dto.PassengerDTO;
import ru.uxair.user.service.PassengerService;
import ru.uxair.user.util.mapper.PassengerMapper;

@RestController
@AllArgsConstructor
public class PassengerControllerImpl implements PassengerController {
    private final PassengerService passengerService;
    private final PassengerMapper passengerMapper;

    @Override
    public ResponseEntity<HttpStatus> addNewPassenger(@NonNull PassengerDTO passengerDTO) {
        passengerService.savePassenger(passengerMapper.convertToPassenger(passengerDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updatePassengerById(long id, @NonNull PassengerDTO passengerDTO) {
        passengerService.updatePassenger(id, passengerMapper.convertToPassenger(passengerDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PassengerDTO> getPassengerById(long id) {
        return ResponseEntity.ok(passengerMapper.convertToPassengerDTO(passengerService.getPassenger(id)));
    }
}
