package ru.uxar1.passengerservice.passengerservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.uxar1.passengerservice.passengerservice.entity.Passenger;
import ru.uxar1.passengerservice.passengerservice.repositiry.PassengerRepository;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    @Transactional
    @Override
    public void savePassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    @Transactional
    @Override
    public void updatePassenger(long id, Passenger updatedPassenger) {
        if (passengerRepository.existsById(id)) {
            updatedPassenger.setId(id);
            updatedPassenger.setFirstName(updatedPassenger.getFirstName());
            updatedPassenger.setMiddleName(updatedPassenger.getMiddleName());
            updatedPassenger.setLastName(updatedPassenger.getLastName());
            updatedPassenger.setDateOfBirth(updatedPassenger.getDateOfBirth());
            updatedPassenger.setUserId(updatedPassenger.getUserId());
            updatedPassenger.setDocuments(updatedPassenger.getDocuments());
            updatedPassenger.setField(updatedPassenger.getField());
            passengerRepository.save(updatedPassenger);
        }
    }

    @Override
    public Passenger getPassenger(long id) {
        return passengerRepository.findById(id).orElse(null);
    }
}
