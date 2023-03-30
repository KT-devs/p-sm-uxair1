package ru.uxair.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.uxair.user.entity.Contact;
import ru.uxair.user.repository.ContactRepository;
import ru.uxair.user.util.exceptions.ResourceNotFoundException;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Transactional
    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Transactional
    @Override
    public void updateContact(Long id, Contact contact) {
        if (contactRepository.existsById(id)) {
            contact.setId(id);
            contact.setType(contact.getType());
            contact.setValue(contact.getValue());
            contact.setPreferredContact(contact.getPreferredContact());
            contactRepository.save(contact);
        } else {
            throw new ResourceNotFoundException("=" + id);
        }
    }

    @Override
    public Contact getContact(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("= " + id));
    }
}
