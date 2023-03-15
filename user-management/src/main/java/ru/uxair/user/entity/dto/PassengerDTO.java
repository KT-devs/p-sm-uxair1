package ru.uxair.user.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@Schema(description = "Information about passenger")
public class PassengerDTO {
    private long id;

    @Schema(description = "Passenger first name")
    @NotEmpty(message = "Input first name")
    private String firstName;

    @NotEmpty(message = "Input middle name")
    private String middleName;

    @Schema(description = "Passenger last name")
    @NotEmpty(message = "Input last name")
    private String lastName;

    @Schema(description = "Passenger birth date")
    @NotEmpty(message = "Input date of birth as YYYY-MM-DD")
    private LocalDate dateOfBirth;

    @NotEmpty(message = "Input user id")
    private String userId;

    @NotEmpty(message = "Input documents")
    private String documents;

    private String field;
}
