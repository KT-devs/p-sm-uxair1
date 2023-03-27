package ru.uxair.flight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.uxair.flight.entity.Destination;
import ru.uxair.flight.repository.DestinationRepository;
import ru.uxair.flight.service.DestinationService;
import ru.uxair.flight.util.exceptions.DestinationNotFoundException;

import java.util.List;

@Service
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository destinationRepository;
    @Autowired
    public DestinationServiceImpl(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public Destination findDestinationById(String id) {
        return destinationRepository.findById(id).orElseThrow(DestinationNotFoundException::new);
    }

    @Override
    public List<Destination> findDestinationByCity(String city) {
        List <Destination> getByCity=destinationRepository.findByCityContainingIgnoreCase(city,
                Sort.by("airportName"));

        if ( !getByCity.isEmpty()) {
            return  getByCity;
        }else {
            throw new DestinationNotFoundException();
        }
    }

    @Override
    public List<Destination> findDestinationByCountryName(String countryName) {

        List<Destination> getByCountryName=destinationRepository.findByCountryNameContainingIgnoreCase(countryName,
                Sort.by("city").and(Sort.by("airportName")));

        if ( !getByCountryName.isEmpty()) {
            return getByCountryName;
        }else {
            throw new DestinationNotFoundException();
        }
    }

    @Override
    public void saveDestination(Destination destination) {
        destinationRepository.save(destination);

    }

    @Override
    public void updateDestination(Destination destination) {
        destinationRepository.save(destination);

    }


}