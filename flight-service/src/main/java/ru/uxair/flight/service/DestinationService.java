package ru.uxair.flight.service;

import ru.uxair.flight.entity.Destination;

import java.util.List;

public interface DestinationService {
    Destination findDestinationById(String airportCode);
    List<Destination> findDestinationByCity(String city);
    List <Destination> findDestinationByCountryName(String countryName);
    void saveDestination(Destination destination);
    void updateDestination(Destination destination);

}
