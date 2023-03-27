package ru.uxair.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.uxair.flight.entity.Destination;

import java.util.List;

public interface DestinationRepository extends JpaRepository <Destination,String> {
    List <Destination> findByCityContainingIgnoreCase(String city);
    List <Destination> findByCountryNameContainingIgnoreCase(String countryName);
}
