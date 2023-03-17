package ru.uxair.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.uxair.user.entity.Document;
import ru.uxair.user.repository.DocumentRepository;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;

    @Transactional
    @Override
    public void saveDocument(Document document) {
        document.setCreatedAt(LocalDateTime.now());
        document.setUpdatedAt(LocalDateTime.now());
        documentRepository.save(document);
    }

    @Transactional
    @Override
    public void updateDocument(long id, Document document) {
        if (documentRepository.existsById(id)) {
            document.setId(id);
            document.setPassenger(document.getPassenger());
            document.setType(document.getType());
            document.setNumber(document.getNumber());
            document.setExpiryDate(document.getExpiryDate());
            document.setCreatedAt(documentRepository.findById(id).get().getCreatedAt());
            document.setUpdatedAt(LocalDateTime.now());
            document.setIsDefault(document.getIsDefault());
            documentRepository.save(document);
        }
    }

    @Override
    public Document getDocument(long id) {
        return documentRepository.findById(id).orElse(null);
    }
}
