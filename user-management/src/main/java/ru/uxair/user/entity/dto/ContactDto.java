package ru.uxair.user.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import ru.uxair.user.entity.ContactType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Schema(description = "Information about user contacts")
public class ContactDto {
    @Positive
    @JsonIgnore
    private Long id;

    @Schema(description = "Contact type")
    @NotNull(message = "Select contact type")
    private ContactType type;

    @Schema(description = "Contact value")
    @NotEmpty(message = "Input contact")
    private String value;

    @Schema(description = "Preferred_contact")
    @NotNull(message = "Preferred contact")
    private Boolean preferredContact;
}
