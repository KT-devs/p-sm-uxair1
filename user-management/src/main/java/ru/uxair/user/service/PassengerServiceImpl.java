package ru.uxair.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.uxair.user.entity.Passenger;
import ru.uxair.user.repository.PassengerRepository;
import ru.uxair.user.util.exceptions.ResourceNotFoundException;

import java.util.List;

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
    public void updatePassenger(Long id, Passenger updatedPassenger) {
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
        } else {
            throw new ResourceNotFoundException("=" + id);
        }
    }

    @Override
    public Passenger getPassenger(Long id) {
        return passengerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("= " + id));
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Transactional
    @Override
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}