package ru.uxair.user.entity.dto;

import lombok.Getter;
import lombok.Setter;
import ru.uxair.user.entity.DocumentType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class DocumentDTO {
    private long id;

    @NotEmpty(message = "Input passenger")
    private String passenger;

    @NotEmpty(message = "Input document type")
    @Enumerated(EnumType.STRING)
    private DocumentType type;

    @NotEmpty(message = "Input document number")
    private long number;

    @NotNull(message = "Input document expire date DD.MM.YYYY")
    private LocalDate expiryDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotEmpty(message = "Document is default?")
    private Boolean isDefault;
}
