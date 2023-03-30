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
import ru.uxair.user.entity.dto.DocumentDto;
import ru.uxair.user.entity.dto.ErrorResponseDto;

import javax.validation.Valid;

@Tag(name = "Document", description = "Methods for document operation")
@RequestMapping("/api/document")
public interface DocumentController {
    /**
     * POST/Document: Method for save document into DB
     *
     * @param documentDto (required)
     * @return Successful get (code 200),
     * Incorrect data (code 400)
     * Incorrect or non-existent field (code 500)
     */
    @Operation(summary = "Method for add document")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DocumentDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @PostMapping()
    ResponseEntity<HttpStatus> addNewDocument(@Parameter(description = "DocumentDto", required = true)
                                               @NonNull @RequestBody @Valid DocumentDto documentDto);

    /**
     * PUT/Document: Method for update document into DB
     *
     * @param id          (required)
     * @param documentDto (required)
     * @return Successful update (code 200),
     * Incorrect data (code 400),
     * Incorrect or non-existent field (code 500)
     */
    @Operation(summary = "Method for update document by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DocumentDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Incorrect or non-existent field",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @PutMapping("/{id}")
    ResponseEntity<HttpStatus> updateDocumentById(
            @Parameter(description = "Unique identifier of document", required = true)
            @NonNull @PathVariable("id") Long id,
            @Parameter(description = "DocumentDTO", required = true)
            @NonNull @RequestBody @Valid DocumentDto documentDto);

    /**
     * GET/Document: Method for get document by id from DB
     *
     * @param id (required)
     * @return Successful get (code 200),
     * Incorrect id (code 400)
     * Non-existent id (code 500)
     */
    @Operation(summary = "Method for get document by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DocumentDto.class))}),
            @ApiResponse(responseCode = "400", description = "Incorrect Id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))}),
            @ApiResponse(responseCode = "500", description = "Non-existent id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponseDto.class))})
    })
    @GetMapping("/{id}")
    ResponseEntity<DocumentDto> getDocumentById(@NonNull @PathVariable("id")
                                                 @Parameter(description = "Unique identifier of document") Long id);
}
