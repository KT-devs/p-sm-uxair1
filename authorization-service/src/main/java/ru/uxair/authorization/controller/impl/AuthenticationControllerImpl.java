package ru.uxair.authorization.controller.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.authorization.controller.AuthenticationController;
import ru.uxair.authorization.entity.dto.AuthenticationRequestDto;
import ru.uxair.authorization.entity.dto.AuthenticationResponseDto;
import ru.uxair.authorization.entity.dto.RegisterRequestDto;
import ru.uxair.authorization.service.impl.AuthenticationServiceImpl;

@RestController
@RequiredArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController {

    private final AuthenticationServiceImpl authenticationServiceImpl;

    @Override
    public ResponseEntity<AuthenticationResponseDto> register (@RequestBody RegisterRequestDto request){
        return ResponseEntity.ok(authenticationServiceImpl.register(request));
    }

    @Override
    public ResponseEntity<AuthenticationResponseDto> authenticate (@RequestBody AuthenticationRequestDto request){
        return ResponseEntity.ok(authenticationServiceImpl.authenticate(request));
    }

}
