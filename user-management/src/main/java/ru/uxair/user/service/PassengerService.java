package ru.uxair.user.service;

import ru.uxair.user.entity.Passenger;

public interface PassengerService {
    void savePassenger(Passenger passenger);
    void updatePassenger(Long id, Passenger updatedPassenger);
    Passenger getPassenger(Long id);
}
