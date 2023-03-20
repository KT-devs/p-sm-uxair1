package ru.uxair.flight.util.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.uxair.flight.entity.Seat;
import ru.uxair.flight.entity.dto.SeatDto;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SeatMapper {
    private final ModelMapper modelMapper;

    private Function<Seat, SeatDto> convertFunctionToSetDto;
    private Function<SeatDto, Seat> convertFunctionToSet;


    public Set<SeatDto> convertToSetSeatDto(Set<Seat> setSeats) {
        return setSeats.stream().map(convertFunctionToSetDto).collect(Collectors.toSet());
    }

    public Set<Seat> convertToSetSeat(Set<SeatDto> setDto) {
        return setDto.stream().map(convertFunctionToSet).collect(Collectors.toSet());
    }

    public Seat convertToSeat(SeatDto seatDto) {
        return modelMapper.map(seatDto, Seat.class);
    }

    public SeatDto convertToSeatDto(Seat seat) {
        return modelMapper.map(seat, SeatDto.class);
    }

}
