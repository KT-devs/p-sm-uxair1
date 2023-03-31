package ru.uxair.flight.util.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.uxair.flight.entity.Seat;
import ru.uxair.flight.service.SeatService;
import ru.uxair.flight.util.exceptions.AbstractResourceNotFoundException;

@Component
public class SeatValidator implements Validator {
    private final SeatService service;

    public SeatValidator(SeatService service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Seat.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Seat seat = (Seat) target;
        try {
            service.findById(seat.getId());
        } catch (AbstractResourceNotFoundException ignored) {
            return;
        }
        errors.rejectValue(
                "Seat id", "", "[Seat with this Id already exists]");
    }
}
