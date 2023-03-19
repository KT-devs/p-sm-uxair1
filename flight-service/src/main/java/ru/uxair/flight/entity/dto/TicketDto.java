package ru.uxair.flight.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import ru.uxair.flight.entity.SeatCategory;
import ru.uxair.user.entity.Passenger;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Schema (description = "Information about ticket")
public class TicketDto {
    @Positive
    @JsonIgnore
    private Long id;
    @Schema(description = "Passenger whose ticket")
    private Passenger passenger;
    @Schema(description = "Ticket reservation")
    @NotEmpty(message = "Can the ticket be booked or not")
    private String booking;
    @Schema(description = "Boarding pass category")
    @NotEmpty(message = "Input boarding pass category")
    private SeatCategory seatCategory;
    @Schema(description = "Ticket FlightServices")
    @NotEmpty(message = "Input FlightServices")
    private String inFlightServices;
    @Schema(description = "Ticket price")
    @NotNull
    private float fare;
    @Schema(description = "Payment currency")
    @NotEmpty
    private float currency;
    @Schema(description = "The flight for which this ticket")
    @NotEmpty
    private String flight;
}
