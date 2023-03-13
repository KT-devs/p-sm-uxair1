package ru.uxar1.passengerservice.passengerservice.entity.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

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

    @Temporal(TemporalType.DATE)
    @NotEmpty(message = "Input date of birth as YYYY-MM-DD")
    private Date dateOfBirth;

    @NotEmpty(message = "Input user id")
    private String userId;

    @NotEmpty(message = "Input documents")
    private String documents;

    @Column(name = "field")
    private String field;
}
