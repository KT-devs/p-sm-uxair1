package ru.uxair.flight.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.uxair.flight.entity.dto.ErrorResponseDto;
import ru.uxair.flight.entity.dto.SeatDto;

import java.util.Set;

@Tag(name = "Seat", description = "Methods for Seat operation")
public interface SeatRestController {
    /**
     * GET/Seat: Method for get All Seat from DB
     *
     * @return Successful get (code 200),
     * Incorrect id (code 400)
     * Non-existent id (code 500)
     */
    @Operation(summary = "Method for get All Seat from DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    ResponseEntity<Set<SeatDto>> getAllSeat();

    /**
     * GET/Seat: Method for get All free Seat
     *
     * @return Successful get (code 200),
     * Incorrect id (code 400)
     * Non-existent id (code 500)
     */
    @Operation(summary = "Method for get All free Seat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    ResponseEntity<Set<SeatDto>> getFreeSeat();


    /**
     * GET/Seat: Method for get All Busy Seat
     *
     * @return Successful get (code 200),
     * Incorrect id (code 400)
     * Non-existent id (code 500)
     */
    @Operation(summary = "Method for get All Busy Seat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    ResponseEntity<Set<SeatDto>> getBusySeat();

    /**
     * GET/Seat: Method for get All reserved Seat
     *
     * @return Successful get (code 200),
     * Incorrect id (code 400)
     * Non-existent id (code 500)
     */
    @Operation(summary = "Method for get All reserved Seat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    ResponseEntity<Set<SeatDto>> getReservedSeat();

    /**
     * GET/Seat: Method for get All Seat in flight
     *
     * @param id (required)
     * @return Successful get (code 200),
     * Incorrect id (code 400)
     * Non-existent id (code 500)
     */
    @Operation(summary = "Method for get All Seat in flight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    ResponseEntity<Set<SeatDto>> getSeatByFlightId(@PathVariable("flight_id") @Parameter(description = "Unique identifier of flight") Long id);

    /**
     * GET/Seat: Method for get All Seat in flight
     *
     * @param flight_id   (required)
     * @param category_id (required)
     * @return Successful get (code 200),
     * Incorrect id (code 400)
     * Non-existent id (code 500)
     */
    @Operation(summary = "Method for get All Seat in flight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    ResponseEntity<Set<SeatDto>> getSeatByFlightId(@PathVariable("flight_id") @Parameter(description = "Unique identifier of flight") Long flight_id,
                                                   @PathVariable("category_id") @Parameter(description = "Unique identifier of category") Long category_id);

    /**
     * POST/Seat: Method for save SeatDto into DB
     *
     * @param seatDto       (required)
     * @param bindingResult (required)
     * @return Successful get (code 200),
     * Incorrect data (code 400)
     * Incorrect or non-existent field (code 500)
     */

    @Operation(summary = "Method for save SeatDto into DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    ResponseEntity<HttpStatus> saveNewSeat(@Parameter(description = "SeatDto", required = true) @RequestBody SeatDto seatDto,
                                           BindingResult bindingResult);

    /**
     * PUT/Seat: Method for update Seat into DB
     *
     * @param seatDto       (required)
     * @param bindingResult (required)
     * @return Successful get (code 200),
     * Incorrect data (code 400)
     * Incorrect or non-existent field (code 500)
     */

    @Operation(summary = "Method for update Seat into DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    ResponseEntity<HttpStatus> updateSeat(@Parameter(description = "SeatDto", required = true) @RequestBody SeatDto seatDto, BindingResult bindingResult);

    /**
     * DELETE/Seat: Method for delete Seat into DB
     *
     * @param id (required)
     * @return Successful get (code 200),
     * Incorrect data (code 400)
     * Incorrect or non-existent field (code 500)
     */

    @Operation(summary = "Method for delete Seat into DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SeatDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    ResponseEntity<HttpStatus> deleteSeat(@PathVariable("id") @Parameter(description = "Unique identifier of seat") Long id);
}
