package ru.uxair.authorizationservice.entity.Dto;

public class ErrorResponseDto {

    private String message;

    public ErrorResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
