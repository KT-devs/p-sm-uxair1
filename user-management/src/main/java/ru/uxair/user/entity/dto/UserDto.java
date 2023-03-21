package ru.uxair.user.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Schema(description = "User data")
public class UserDto {
    @Positive
    @JsonIgnore
    private Long id;

    @Schema(description = "User name")
    @NotNull(message = "Input user name")
    private String userName;// Temporary type String as plug

    @Schema(description = "User contacts")
    @NotNull(message = "Input your contacts")
    private String contacts;// Temporary type String as plug
}
