package ru.uxair.flight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
        if ( !destinationRepository.findByCityContainingIgnoreCase(city).isEmpty()) {
            return destinationRepository.findByCountryNameContainingIgnoreCase(city);
        }else {
            throw new DestinationNotFoundException();
        }
    }

    @Override
    public List<Destination> findDestinationByCountryName(String countryName) {

        if ( !destinationRepository.findByCountryNameContainingIgnoreCase(countryName).isEmpty()) {
            return destinationRepository.findByCountryNameContainingIgnoreCase(countryName);
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