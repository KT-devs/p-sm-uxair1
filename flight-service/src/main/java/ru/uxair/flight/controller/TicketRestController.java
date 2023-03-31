package ru.uxair.flight.controller;

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
import ru.uxair.flight.entity.dto.ErrorResponseDto;
import ru.uxair.flight.entity.dto.TicketDto;

import javax.validation.Valid;

@Tag(name = "Ticket", description = "Methods for ticket operation")
@RequestMapping("/api/ticket")
public interface TicketRestController {
    /**
     * POST/Ticket: Method for save TicketDto into DB
     *
     * @param ticketDto (required)
     * @return Successful get (code 200),
     * Incorrect data (code 400)
     * Incorrect or non-existent field (code 500)
     */
    @Operation(summary = "Method for add ticket")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TicketDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @PostMapping()
    ResponseEntity<HttpStatus> saveNewTicket(@Parameter(description = "TicketDto", required = true)
                                             @NonNull @RequestBody @Valid TicketDto ticketDto);

    /**
     * PUT/Ticket: Method for update ticker into DB
     *
     * @param id (required)
     * @return Successful update (code 200),
     * Incorrect data (code 400),
     * Incorrect or non-existent field (code 500)
     */
    @Operation(summary = "Method for update ticket by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TicketDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @PutMapping("/{id}")
    ResponseEntity<HttpStatus> updateTicketById(
            @Parameter(description = "Unique identifier of ticket", required = true)
            @NonNull @PathVariable("id") Long id);

    /**
     * GET/Ticket: Method for get ticket by id from DB
     *
     * @param id (required)
     * @return Successful get (code 200),
     * Incorrect id (code 400)
     * Non-existent id (code 500)
     */
    @Operation(summary = "Method for get ticket by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TicketDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @GetMapping("/{id}")
    ResponseEntity<TicketDto> getTicketById(@NonNull @PathVariable("id")
                                            @Parameter(description = "Unique identifier of ticket") Long id);

    /**
     * Delete/Ticket: Method for delete ticket by id from DB
     *
     * @param id (required)
     * @return Successful get (code 200),
     * Incorrect id (code 400)
     * Non-existent id (code 500)
     */
    @Operation(summary = "Method for delete ticket by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TicketDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @GetMapping("/{id}")
    ResponseEntity<HttpStatus> deleteTicketById(@NonNull @PathVariable("id")
                                                @Parameter(description = "Unique identifier of ticket") Long id);
}
