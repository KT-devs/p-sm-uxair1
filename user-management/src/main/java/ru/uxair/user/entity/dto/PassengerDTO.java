package ru.uxair.user.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
@Schema(description = "Information about passenger")
public class PassengerDTO {
//    @JsonIgnore
    @Positive
    private long id;

    @Schema(description = "Passenger first name")
    @NotEmpty(message = "Input first name")
    private String firstName;

    @Schema(description = "Passenger middle name")
    @NotEmpty(message = "Input middle name")
    private String middleName;

    @Schema(description = "Passenger last name")
    @NotEmpty(message = "Input last name")
    private String lastName;

    @Schema(description = "Passenger birth date")
    @NotNull(message = "Input date of birth as YYYY-MM-DD")
    private LocalDate dateOfBirth;

    @Schema(description = "User id")
    @NotEmpty(message = "Input user id")
    private String userId;

    @Schema(description = "Documents")
    @NotEmpty(message = "Input documents")
    private String documents;

    @Schema(description = "Field")
    private String field;
}
