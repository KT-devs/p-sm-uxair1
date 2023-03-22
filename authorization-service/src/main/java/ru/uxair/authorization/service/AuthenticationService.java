package ru.uxair.authorization.service;


import ru.uxair.authorization.controller.security.AuthenticationRequest;
import ru.uxair.authorization.controller.security.AuthenticationResponse;
import ru.uxair.authorization.controller.security.RegisterRequest;


public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

}
