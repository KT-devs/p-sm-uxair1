package ru.uxair.authorization.entity.dto;

import lombok.Value;

import javax.validation.constraints.NotEmpty;

@Value
public class AuthenticationRequestDto {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
}
