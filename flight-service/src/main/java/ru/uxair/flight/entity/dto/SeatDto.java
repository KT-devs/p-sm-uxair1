package ru.uxair.flight.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
@Schema(description = "Information about seat")
public class SeatDto {
    @Positive
    @JsonIgnore
    private Long id;
    @Schema(description = "Seat in this aircraft")
    private Long aircraft;                          //todo когда появится aircraft доделать метод
    @Schema(description = "Type Seat")
    private Long seatType;                       //todo когда появится seatType доделать метод
    @Schema(description = "Number Seat")
    private String seatNumber;
}
