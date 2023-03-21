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
import org.springframework.web.bind.annotation.*;
import ru.uxair.user.entity.Passenger;
import ru.uxair.user.entity.dto.ErrorResponseDto;
import ru.uxair.user.entity.dto.PassengerDTO;
import ru.uxair.user.entity.dto.UserDto;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "User", description = "Methods for user operation")
@RequestMapping("/api/user")
public interface UserController extends PassengerController{
/**
 * PUT/User: Method for update user into DB
 *
 * @param id           (required)
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

    /**
     * GET/Passenger: Method for get passengers from DB
     *
     * @return Successful get (code 200),
     * Incorrect id (code 400)
     * Non-existent id (code 500)
     */
    @Operation(summary = "Method for get passenger by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PassengerDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect Id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Non-existent id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @GetMapping()
    ResponseEntity<List<PassengerDTO>> getAllPassengers();

    /**
     * DELETE/Passenger: Method for delete passenger by id from DB
     *
     * @param id (required)
     * @return Successful get (code 200),
     * Incorrect id (code 400)
     * Non-existent id (code 500)
     */
    @Operation(summary = "Method for add passenger")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PassengerDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> deletePassengerById(@NonNull @PathVariable("id")
                                               @Parameter(description = "Unique identifier of passenger") Long id);
}
