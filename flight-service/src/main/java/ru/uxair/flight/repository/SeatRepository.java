package ru.uxair.flight.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.uxair.flight.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    Seat findSeatBySeatNumber(String seatNumber);
    Seat findSeatBySeatTypeCategory(long category);
    Seat findSeatByAircraft(long flightId);
}
