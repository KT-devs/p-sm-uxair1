package ru.uxair.user.service;

import ru.uxair.user.entity.Passenger;

public interface PassengerService {
    void savePassenger(Passenger passenger);
    void updatePassenger(long id, Passenger updatedPassenger);
    Passenger getPassenger(long id);
}
