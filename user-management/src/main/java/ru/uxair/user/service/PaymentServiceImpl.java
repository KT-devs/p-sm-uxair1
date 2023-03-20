package ru.uxair.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.uxair.user.entity.Payment;
import ru.uxair.user.repository.PaymentRepository;
import ru.uxair.user.util.exceptions.ResourceNotFoundException;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Transactional
    @Override
    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Transactional
    @Override
    public void updatePayment(Long id, Payment payment) {
        if (paymentRepository.existsById(id)) {
            payment.setId(id);
            payment.setUser(payment.getUser());
            payment.setSum(payment.getSum());
            payment.setCurrency(payment.getCurrency());
            payment.setCard(payment.getCard());
            payment.setBookingId(payment.getBookingId());
            paymentRepository.save(payment);
        } else {
            throw new ResourceNotFoundException("=" + id);
        }
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("= " + id));
    }
}
