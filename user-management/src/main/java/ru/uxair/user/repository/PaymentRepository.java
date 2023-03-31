package ru.uxair.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uxair.user.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
