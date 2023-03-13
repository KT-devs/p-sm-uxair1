package ru.uxar1.passengerservice.passengerservice.service;

import ru.uxar1.passengerservice.passengerservice.entity.Passenger;

public interface PassengerService {
    void savePassenger(Passenger passenger);
    void updatePassenger(long id, Passenger updatedPassenger);
    Passenger getPassenger(long id);
}
