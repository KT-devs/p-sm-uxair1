package ru.uxair.user.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.user.entity.dto.DocumentDto;
import ru.uxair.user.service.DocumentService;
import ru.uxair.user.util.mapper.DocumentMapper;

@RestController
@AllArgsConstructor
public class DocumentControllerImpl implements DocumentController {
    private final DocumentService documentService;
    private final DocumentMapper documentMapper;

    @Override
    public ResponseEntity<HttpStatus> addNewDocument(@NonNull DocumentDto documentDto) {
        documentService.saveDocument(documentMapper.convertToDocument(documentDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updateDocumentById(@NonNull Long id, @NonNull DocumentDto documentDto) {
        documentService.updateDocument(id, documentMapper.convertToDocument(documentDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DocumentDto> getDocumentById(@NonNull Long id) {
        return ResponseEntity.ok(documentMapper.convertToDocumentDTO(documentService.getDocument(id)));
    }
}
