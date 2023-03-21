package ru.uxair.user.service;

import ru.uxair.user.entity.Passenger;

import java.util.List;

public interface PassengerService {
    void savePassenger(Passenger passenger);
    void updatePassenger(Long id, Passenger updatedPassenger);
    Passenger getPassenger(Long id);
    List<Passenger> getAllPassengers();
    void deletePassenger(Long id);
}
