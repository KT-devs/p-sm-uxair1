package ru.uxair.user.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.uxair.user.entity.Passenger;
import ru.uxair.user.entity.dto.ErrorResponseDto;
import ru.uxair.user.repository.PassengerRepository;
import ru.uxair.user.util.exceptions.ResourceAlreadyExistsException;
import ru.uxair.user.util.exceptions.ResourceNotFoundException;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    @Transactional
    @Override
    public void savePassenger(Passenger passenger) {
//        if (passengerRepository.existsById(passenger.getId())) {
//            throw new ResourceAlreadyExistsException("=" + passenger.getId());
////            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
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
//        } else {
//            throw new ResourceNotFoundException("=" + id);
//            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Passenger getPassenger(long id) {
//        if (!passengerRepository.existsById(id)) {
//            throw new ResourceNotFoundException("=" + id);
//            new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            new ErrorResponseDto("NOT FOUND!!!");
//        }
        return passengerRepository.findById(id).orElse(null);
    }
}
