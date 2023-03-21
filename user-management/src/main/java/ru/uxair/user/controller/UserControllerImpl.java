package ru.uxair.user.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.user.entity.Passenger;
import ru.uxair.user.entity.dto.PassengerDTO;
import ru.uxair.user.entity.dto.UserDto;
import ru.uxair.user.service.PassengerService;
import ru.uxair.user.service.UserService;
import ru.uxair.user.util.mapper.PassengerMapper;
import ru.uxair.user.util.mapper.UserMapper;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;
    private final PassengerService passengerService;
    private final UserMapper userMapper;
    private final PassengerMapper passengerMapper;

    @Override
    public ResponseEntity<HttpStatus> addNewPassenger(@NonNull PassengerDTO passengerDTO) {
        passengerService.savePassenger(passengerMapper.convertToPassenger(passengerDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updatePassengerById(@NonNull Long id, @NonNull PassengerDTO passengerDTO) {
        passengerService.updatePassenger(id, passengerMapper.convertToPassenger(passengerDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PassengerDTO> getPassengerById(@NonNull Long id) {
        return ResponseEntity.ok(passengerMapper.convertToPassengerDTO(passengerService.getPassenger(id)));
    }

    @Override
    public ResponseEntity<HttpStatus> updateUserDataById(@NonNull Long id, @NonNull UserDto userDto) {
        userService.updateUserData(id, userMapper.convertToUser(userDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deletePassengerById(@NonNull Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PassengerDTO>> getAllPassengers() {
        return ResponseEntity.ok(passengerMapper.convertToPassengerDTO(passengerService.getAllPassengers()));
    }
}
