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
import ru.uxair.user.entity.dto.ErrorResponseDTO;
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
     * Incorrect or non-existent field (code 500)
     */
    @Operation(summary = "Method for add passenger")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PassengerDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))})
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
     * Incorrect or non-existent id or field (code 500)
     */
    @Operation(summary = "Method for update passenger by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PassengerDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))})
    })
    @PutMapping("/{id}")
    ResponseEntity<HttpStatus> updatePassengerById(
            @NonNull @Parameter(description = "Unique identifier of passenger", required = true)
            @PathVariable("id") long id,
            @NonNull @Parameter(description = "PassengerDTO", required = true)
            @RequestBody @Valid PassengerDTO passengerDTO);

    /**
     * GET/Passenger: Method for get passenger by id from DB
     *
     * @param id (required)
     * @return Successful get (code 200),
     * Incorrect or non-existent id (code 500)
     */
    @Operation(summary = "Method for get passenger by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PassengerDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDTO.class))})
    })
    @GetMapping("/{id}")
    ResponseEntity<PassengerDTO> getPassengerById(@PathVariable("id") @NonNull
                                                  @Parameter(description = "Unique identifier of passenger") long id);
}
