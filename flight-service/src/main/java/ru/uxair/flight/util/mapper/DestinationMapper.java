package ru.uxair.flight.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.uxair.flight.entity.Destination;
import ru.uxair.flight.entity.dto.DestinationDto;

@Component
public class DestinationMapper {

    private final ModelMapper modelMapper;

    public DestinationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public Destination convertToDestination(DestinationDto destinationDto) {
        return modelMapper.map( destinationDto, Destination.class);
    }

    public  DestinationDto convertToDestinationDto( Destination destination) {
        return modelMapper.map(destination, DestinationDto.class);
    }

}