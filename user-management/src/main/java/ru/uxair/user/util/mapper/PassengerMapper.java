package ru.uxair.user.util.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.uxair.user.entity.Passenger;
import ru.uxair.user.entity.dto.PassengerDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PassengerMapper {
    private final ModelMapper modelMapper;

    public Passenger convertToPassenger(PassengerDTO passengerDTO) {
        return modelMapper.map(passengerDTO, Passenger.class);
    }

    public PassengerDTO convertToPassengerDTO(Passenger passenger) {
        return modelMapper.map(passenger, PassengerDTO.class);
    }

    public List<PassengerDTO> convertToListPassengerDTO(List<Passenger> passengerList) {
        return passengerList.stream().map(this::convertToPassengerDTO).collect(Collectors.toList());
    }
}
