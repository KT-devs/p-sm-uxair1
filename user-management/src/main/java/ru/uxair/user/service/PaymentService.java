package ru.uxair.user.service;

import ru.uxair.user.entity.Payment;

public interface PaymentService {
    void savePayment(Payment payment);
    void updatePayment(Long id, Payment payment);
    Payment getPayment(Long id);
}
