package ru.uxair.flight.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Error in case response")
public class ErrorResponseDto {
    @Schema(description = "Message about Error")
    private String message;

    public ErrorResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
