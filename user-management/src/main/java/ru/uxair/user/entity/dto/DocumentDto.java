package ru.uxair.user.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "Document information")
public class DocumentDto {
    @Positive
    @JsonIgnore
    private Long id;

    @Schema(description = "Passenger")
    @NotEmpty(message = "Input passenger")
    private String passenger;

    @Schema(description = "Document type")
    @NotNull(message = "Select document type")
    @Enumerated(EnumType.STRING)
    private String type; // ToDo DocumentType

    @Schema(description = "Document number")
    @NotNull(message = "Input document number")
    private Long number;

    @Schema(description = "Expiry date")
    @NotNull(message = "Input document expire date as YYYY.MM.DD")
    private LocalDate expiryDate;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    private LocalDateTime updatedAt;

    @Schema(description = "Default/non-default")
    @NotNull(message = "Document is default?")
    private Boolean isDefault;
}
