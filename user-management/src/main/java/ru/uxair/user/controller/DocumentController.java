package ru.uxair.user.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.uxair.user.entity.Document;
import ru.uxair.user.entity.dto.DocumentDTO;
import ru.uxair.user.service.DocumentService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/document")
@AllArgsConstructor
public class DocumentController {
    private final DocumentService documentService;
    private final ModelMapper modelMapper;

    @PostMapping()
    public ResponseEntity<HttpStatus> addNewDocument(@RequestBody @Valid DocumentDTO documentDTO){
        documentService.saveDocument(convertToDocument(documentDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateDocumentById(@PathVariable("id") long id,
                                                         @RequestBody @Valid DocumentDTO documentDTO){
        documentService.updateDocument(id, convertToDocument(documentDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> getDocumentById(@PathVariable("id") long id){
        return ResponseEntity.ok(convertToDocumentDTO(documentService.getDocument(id)));
    }

    private Document convertToDocument(DocumentDTO documentDTO) {
        return modelMapper.map(documentDTO, Document.class);
    }

    private DocumentDTO convertToDocumentDTO(Document document) {
        return modelMapper.map(document, DocumentDTO.class);
    }
}
