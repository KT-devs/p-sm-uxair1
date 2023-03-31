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
import ru.uxair.user.entity.dto.PaymentDto;

import javax.validation.Valid;

@Tag(name = "Payment", description = "Methods for payment operation")
@RequestMapping("/api/payment")
public interface PaymentController {
    /**
     * POST/Payment: Method for save payment into DB
     *
     * @param paymentDto (required)
     * @return Successful get (code 200),
     * Incorrect data (code 400)
     * Incorrect or non-existent field (code 500)
     */
    @Operation(summary = "Method for add payment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @PostMapping()
    ResponseEntity<HttpStatus> addNewPayment(@Parameter(description = "PaymentDto", required = true)
                                             @NonNull @RequestBody @Valid PaymentDto paymentDto);

    /**
     * PUT/Payment: Method for update payment into DB
     *
     * @param id         (required)
     * @param paymentDto (required)
     * @return Successful update (code 200),
     * Incorrect data (code 400),
     * Incorrect or non-existent field (code 500)
     */
    @Operation(summary = "Method for update payment by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @PutMapping("/{id}")
    ResponseEntity<HttpStatus> updatePaymentById(
            @Parameter(description = "Unique identifier of payment", required = true)
            @NonNull @PathVariable("id") Long id,
            @Parameter(description = "PaymentDto", required = true)
            @NonNull @RequestBody @Valid PaymentDto paymentDto);

    /**
     * GET/Payment: Method for get payment by id from DB
     *
     * @param id (required)
     * @return Successful get (code 200),
     * Incorrect id (code 400)
     * Non-existent id (code 500)
     */
    @Operation(summary = "Method for get payment by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect Id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Non-existent id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @GetMapping("/{id}")
    ResponseEntity<PaymentDto> getPaymentById(@NonNull @PathVariable("id")
                                              @Parameter(description = "Unique identifier of payment") Long id);
}
