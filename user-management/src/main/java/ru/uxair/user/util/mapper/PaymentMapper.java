package ru.uxair.user.util.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.uxair.user.entity.Payment;
import ru.uxair.user.entity.dto.PaymentDto;

@Component
@AllArgsConstructor
public class PaymentMapper {
    private final ModelMapper modelMapper;

    public Payment convertToPayment(PaymentDto paymentDto) {
        return modelMapper.map(paymentDto, Payment.class);
    }

    public PaymentDto convertToPaymentDto(Payment payment) {
        return modelMapper.map(payment, PaymentDto.class);
    }
}
