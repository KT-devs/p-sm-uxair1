package ru.uxair.user.service;

import ru.uxair.user.entity.Document;

public interface DocumentService {
    void saveDocument(Document document);
    void updateDocument(long id, Document document);
    Document getDocument(long id);
}
