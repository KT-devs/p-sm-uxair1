package ru.uxair.authorization.entity.dto;

import lombok.*;
import ru.uxair.authorization.entity.Role;

import java.util.Date;


@Value
public class RegisterRequestDto {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;

}
