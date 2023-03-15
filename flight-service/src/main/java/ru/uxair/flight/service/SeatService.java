package ru.uxair.flight.service;

import ru.uxair.flight.entity.Seat;

import java.util.Set;

public interface SeatService {
    Seat findById(long id);

    Set<Seat> getAllSeat();

    Set<Seat> getFreeSeat();

    Set<Seat> getBusySeat();

    Set<Seat> getReservedSeat();

    void createSeat(Seat seat);
    void updateSeat(Seat seat);
    void deleteSeat(Long id);
    Set <Seat> findByFlightId(long flightId);
    Set <Seat> findByFlightIdAndCategoryId(long flightId, long categoryId);

}

