package ru.uxair.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uxair.user.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
