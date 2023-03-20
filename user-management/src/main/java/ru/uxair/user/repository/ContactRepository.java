package ru.uxair.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uxair.user.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
}
