package ru.uxair.flight.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.controller.DestinationController;
import ru.uxair.flight.entity.dto.DestinationDto;
import ru.uxair.flight.service.DestinationService;
import ru.uxair.flight.util.mapper.DestinationMapper;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v.1/destinations")

public class DestinationControllerImpl implements DestinationController {

    private final DestinationService service;
    private final DestinationMapper mapper;



    public DestinationControllerImpl(DestinationService service, DestinationMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


    @Override
    @GetMapping("/{id}")
    public ResponseEntity<DestinationDto> getDestinationById( @PathVariable String id) {
        DestinationDto destinationById = mapper.convertToDestinationDto(service.findDestinationById(id));
        return destinationById != null
                ? new ResponseEntity<>(destinationById, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

           @Override
    @GetMapping("/city/{city}")
    public ResponseEntity < List<DestinationDto>> getDestinationByCity(@PathVariable String city) {
        List <DestinationDto> getByCity=  service.findDestinationByCity(city).
                stream().
                map(mapper::convertToDestinationDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(getByCity,HttpStatus.OK);
    }

    @Override
    @GetMapping("/countryName/{countryName}")
    public ResponseEntity <List<DestinationDto>> getDestinationByCountry(@PathVariable String countryName) {
        List <DestinationDto> getByCountryName= service.findDestinationByCountryName(countryName).
                stream().
                map(mapper::convertToDestinationDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(getByCountryName,HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<HttpStatus> createDestination(DestinationDto destinationDto) {
        service.saveDestination(mapper.convertToDestination(destinationDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<HttpStatus> updateDestination(DestinationDto destinationDto) {
        service.saveDestination(mapper.convertToDestination(destinationDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
