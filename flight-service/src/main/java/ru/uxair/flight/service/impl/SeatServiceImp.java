package ru.uxair.flight.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.uxair.flight.entity.Seat;
import ru.uxair.flight.repository.SeatRepository;
import ru.uxair.flight.service.SeatService;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class SeatServiceImp implements SeatService {
    private final SeatRepository seatRepository;

    public SeatServiceImp(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Seat findById(long id) {
        return seatRepository.findById(id).get();
    }

    @Override
    public Set<Seat> getAllSeat() {
        return new HashSet<>(seatRepository.findAll());
    }

    @Override
    public Set<Seat> getFreeSeat() {
        return null;
    } //todo когда появится aircraft доделать метод

    @Override
    public Set<Seat> getBusySeat() {
        return null;
    } //todo когда появится aircraft доделать метод

    @Override
    public Set<Seat> getReservedSeat() {
        return null;
    } //todo когда появится aircraft доделать метод

    @Transactional
    @Override
    public void createSeat(Seat seat) {
        seatRepository.save(seat);
    }

    @Transactional
    @Override
    public void updateSeat(Seat seat) {
        seatRepository.saveAndFlush(seat);
    }

    @Transactional
    @Override
    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }

    @Override
    public Set<Seat> findByFlightId(long flightId) {
        seatRepository.findSeatByAircraft(flightId).getAircraft(); //todo когда появится aircraft доделать метод
        return null;
    }

    @Override
    public Set<Seat> findByFlightIdAndCategoryId(long flightId, long categoryId) { //todo когда появится aircraft доделать метод
        return null;
    }
}
