package ru.uxair.authorization.controller.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.uxair.authorization.entity.Role;

import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private Date dateRegistration; //YYYY-MM-DD
    private String password;
    private Role role;

}
