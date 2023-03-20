package ru.uxair.user.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.user.entity.dto.PaymentDto;
import ru.uxair.user.service.PaymentServiceImpl;
import ru.uxair.user.util.mapper.PaymentMapper;

@RestController
@AllArgsConstructor
public class PaymentControllerImpl implements PaymentController {
    private final PaymentServiceImpl paymentService;
    private final PaymentMapper paymentMapper;

    @Override
    public ResponseEntity<HttpStatus> addNewPayment(@NonNull PaymentDto paymentDto) {
        paymentService.savePayment(paymentMapper.convertToPayment(paymentDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updatePaymentById(@NonNull Long id, @NonNull PaymentDto paymentDto) {
        paymentService.updatePayment(id, paymentMapper.convertToPayment(paymentDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PaymentDto> getPaymentById(@NonNull Long id) {
        return ResponseEntity.ok(paymentMapper.convertToPaymentDto(paymentService.getPayment(id)));
    }
}
