package ru.uxair.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uxair.user.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
