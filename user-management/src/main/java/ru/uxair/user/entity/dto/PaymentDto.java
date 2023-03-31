package ru.uxair.user.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Schema(description = "Document information")
public class PaymentDto {
    @Positive
    @JsonIgnore
    private Long id;

    @Schema(description = "Payment")
    @NotEmpty(message = "Input user")
    private String user; // Temporary type String as plug, ToDo: User service and table links (joins)

    @Schema(description = "Sum of payment")
    @NotNull(message = "Input sum")
    private Double sum;

    @Schema(description = "Payment currency")
    @NotEmpty(message = "Input currency")
    private String currency;

    @Schema(description = "Card")
    @NotEmpty(message = "Input card")
    private String card;

    @Schema(description = "Booking id")
    @NotNull(message = "Input bookingId")
    private Long bookingId;

}
