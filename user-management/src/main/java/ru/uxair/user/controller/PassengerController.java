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
import ru.uxair.user.entity.dto.ErrorResponseDto;
import ru.uxair.user.entity.dto.PassengerDTO;

import javax.validation.Valid;

@Tag(name = "Passenger", description = "Methods for passenger operation")
@RequestMapping("/api/passenger")
public interface PassengerController {
    /**
     * POST/Passenger: Method for save passenger into DB
     *
     * @param passengerDTO (required)
     * @return Successful get (code 200),
     * Incorrect data (code 400)
     * Incorrect or non-existent field (code 500)
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
    @PostMapping()
    ResponseEntity<HttpStatus> addNewPassenger(@Parameter(description = "PassengerDTO", required = true)
                                               @NonNull @RequestBody @Valid PassengerDTO passengerDTO);

    /**
     * PUT/Passenger: Method for update passenger into DB
     *
     * @param id           (required)
     * @param passengerDTO (required)
     * @return Successful update (code 200),
     * Incorrect data (code 400),
     * Incorrect or non-existent field (code 500)
     */
    @Operation(summary = "Method for update passenger by id")
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
    @PutMapping("/{id}")
    ResponseEntity<HttpStatus> updatePassengerById(
            @Parameter(description = "Unique identifier of passenger", required = true)
            @NonNull @PathVariable("id") Long id,
            @Parameter(description = "PassengerDTO", required = true)
            @NonNull @RequestBody @Valid PassengerDTO passengerDTO);

    /**
     * GET/Passenger: Method for get passenger by id from DB
     *
     * @param id (required)
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
    @GetMapping("/{id}")
    ResponseEntity<PassengerDTO> getPassengerById(@NonNull @PathVariable("id")
                                                  @Parameter(description = "Unique identifier of passenger") Long id);
}
