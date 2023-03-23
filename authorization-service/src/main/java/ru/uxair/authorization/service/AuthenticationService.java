package ru.uxair.authorization.service;


import ru.uxair.authorization.entity.dto.AuthenticationRequestDto;
import ru.uxair.authorization.entity.dto.AuthenticationResponseDto;
import ru.uxair.authorization.entity.dto.RegisterRequestDto;


public interface AuthenticationService {

    AuthenticationResponseDto register(RegisterRequestDto request);

    AuthenticationResponseDto authenticate(AuthenticationRequestDto request);

}
