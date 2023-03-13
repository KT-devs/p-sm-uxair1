package ru.uxar1.passengerservice.passengerservice.entity.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
public class PassengerDTO {
    private long id;

    @NotEmpty(message = "Input first name")
    private String firstName;

    @NotEmpty(message = "Input middle name")
    private String middleName;

    @NotEmpty(message = "Input last name")
    private String lastName;

    @NotEmpty(message = "Input date of birth as YYYY-MM-DD")
    private LocalDate dateOfBirth;

    @NotEmpty(message = "Input user id")
    private String userId;

    @NotEmpty(message = "Input documents")
    private String documents;

    private String field;
}
