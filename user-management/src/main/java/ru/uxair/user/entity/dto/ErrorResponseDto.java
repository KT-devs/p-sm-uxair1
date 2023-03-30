package ru.uxair.user.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Error in case response")
public class ErrorResponseDto {
    @Schema(description = "Message about Error")
    private String message;
}
