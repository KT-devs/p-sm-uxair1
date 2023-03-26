package ru.uxair.user.service;

import ru.uxair.user.entity.Contact;

public interface ContactService {
    void saveContact(Contact contact);
    void updateContact(Long id, Contact contact);
    Contact getContact(Long id);
}
