package ru.uxair.user.util.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.uxair.user.entity.Document;
import ru.uxair.user.entity.dto.DocumentDto;

@Component
@AllArgsConstructor
public class DocumentMapper {
    private final ModelMapper modelMapper;

    public Document convertToDocument(DocumentDto documentDto) {
        return modelMapper.map(documentDto, Document.class);
    }

    public DocumentDto convertToDocumentDTO(Document document) {
        return modelMapper.map(document, DocumentDto.class);
    }
}
