package ru.uxair.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.uxair.user.entity.dto.ErrorResponseDto;
import ru.uxair.user.entity.dto.UserDto;

import javax.validation.Valid;

@Tag(name = "User", description = "Methods for user operation")
@RequestMapping("/api/user")
public interface UserController {
    /**
     * PUT/User: Method for update user into DB
     *
     * @param id      (required)
     * @param userDto (required)
     * @return Successful update (code 200),
     * Incorrect data (code 400),
     * Incorrect or non-existent field (code 500)
     */
    @Operation(summary = "Method for update passenger by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @PutMapping("/{id}")
    ResponseEntity<HttpStatus> updateUserDataById(
            @Parameter(description = "Unique identifier of user", required = true)
            @NonNull @PathVariable("id") Long id,
            @Parameter(description = "UserDto", required = true)
            @NonNull @RequestBody @Valid UserDto userDto);
}
