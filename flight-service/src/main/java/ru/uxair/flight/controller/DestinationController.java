package ru.uxair.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.uxair.flight.entity.dto.DestinationDto;
import java.util.List;


public interface DestinationController {
    ResponseEntity<DestinationDto> getDestinationById(@PathVariable(value = "id") String id);
    ResponseEntity <List<DestinationDto>> getDestinationByCity (@PathVariable (value="city") String city);
    ResponseEntity  <List<DestinationDto>> getDestinationByCountry (@PathVariable(value="countryName") String countryName);
    ResponseEntity <HttpStatus> createDestination (@RequestBody DestinationDto destinationDto);
    ResponseEntity<HttpStatus> updateDestination (@RequestBody DestinationDto destinationDto);

}