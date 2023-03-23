package ru.uxair.authorization.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.uxair.authorization.entity.dto.AuthenticationRequestDto;
import ru.uxair.authorization.entity.dto.AuthenticationResponseDto;
import ru.uxair.authorization.entity.dto.ErrorResponseDto;
import ru.uxair.authorization.entity.dto.RegisterRequestDto;

@Tag (name = "Authenticate controller")
@RequestMapping ("/api/v1")
public interface AuthenticationController {


    /**
     * POST: method for registering new users
     *
     * @param request Dto
     * @return ResponseEntity<AuthenticationResponseDto>
     */
    @Operation(summary = "Get access token on registration")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Page successfully returned",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthenticationResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Page not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @PostMapping("/register")
    ResponseEntity<AuthenticationResponseDto> register (@RequestBody RegisterRequestDto request);


    /**
     * POST: method for authenticate existing users
     *
     * @param request Dto
     * @return ResponseEntity<AuthenticationResponseDto>
     */
    @Operation(summary = "Get access token on authentication")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Page successfully returned",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthenticationResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Page not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @PostMapping("/authenticate")
    ResponseEntity<AuthenticationResponseDto> authenticate (@RequestBody AuthenticationRequestDto request);

}
