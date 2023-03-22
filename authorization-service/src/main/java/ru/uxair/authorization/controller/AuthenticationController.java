package ru.uxair.authorization.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.authorization.controller.security.AuthenticationRequest;
import ru.uxair.authorization.controller.security.AuthenticationResponse;
import ru.uxair.authorization.controller.security.RegisterRequest;
import ru.uxair.authorization.service.impl.AuthenticationServiceImpl;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationServiceImpl.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationServiceImpl.authenticate(request));
    }

}
