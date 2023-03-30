package ru.uxair.flight.controller.impl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.flight.controller.DestinationController;
import ru.uxair.flight.entity.Destination;
import ru.uxair.flight.entity.dto.DestinationDto;
import ru.uxair.flight.service.DestinationService;
import ru.uxair.flight.util.mapper.DestinationMapper;

import javax.validation.Valid;
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
    @Operation(
            tags = {"Destination"}



    )
    public ResponseEntity <DestinationDto>getDestinationById(@Parameter @PathVariable  String id) {


        DestinationDto destinationById = mapper.convertToDestinationDto(service.findDestinationById(id));

        return destinationById != null
                ? new ResponseEntity<>(destinationById, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping("/city/{city}")
    @Operation(
            tags = {"Destination"}



    )
    public ResponseEntity < List<DestinationDto>> getDestinationByCity(@Parameter @PathVariable String city) {


        List<DestinationDto> getByCity = service.findDestinationByCity(city).
                stream().
                map(mapper::convertToDestinationDto)
                .collect(Collectors.toList());
        if (!getByCity.isEmpty()) {
            return new ResponseEntity<>(getByCity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    @Override
    @GetMapping("/countryName/{countryName}")
    @Operation(
            tags = {"Destination"}



    )
    public ResponseEntity <List<DestinationDto>> getDestinationByCountry(@Parameter @PathVariable String countryName) {
        List <DestinationDto> getByCountryName= service.findDestinationByCountryName(countryName).
                stream().
                map(mapper::convertToDestinationDto)
                .collect(Collectors.toList());
        if (!getByCountryName.isEmpty()) {
            return new ResponseEntity<>(getByCountryName, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @PostMapping
    @Operation(
            tags = {"Destination"}



    )
    public ResponseEntity<HttpStatus> createDestination(@RequestBody @Valid DestinationDto destinationDto) {
        service.saveDestination(mapper.convertToDestination(destinationDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @PutMapping
    @Operation(
            tags = {"Destination"},
            summary = "This is update of destination",
            description = "This is update of destination",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "This  is the request body desc",
            content = @Content(schema = @Schema(implementation = Destination.class))),
            responses = {@ApiResponse (responseCode = "200",description = "Success Response",
                    content = @Content(examples = @ExampleObject(value = "{}"))
            )}




    )
    public ResponseEntity<HttpStatus> updateDestination(@RequestBody @Valid DestinationDto destinationDto) {
        service.saveDestination(mapper.convertToDestination(destinationDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
