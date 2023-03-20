package ru.uxair.user.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.user.entity.dto.ContactDto;
import ru.uxair.user.service.ContactService;
import ru.uxair.user.util.mapper.ContactMapper;

@RestController
@AllArgsConstructor
public class ContactControllerImpl implements ContactController {
    private final ContactService contactService;
    private final ContactMapper contactMapper;

    @Override
    public ResponseEntity<HttpStatus> addNewContact(@NonNull ContactDto contactDto) {
        contactService.saveContact(contactMapper.convertToContact(contactDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> updateContactById(@NonNull Long id, @NonNull ContactDto contactDto) {
        contactService.updateContact(id, contactMapper.convertToContact(contactDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ContactDto> getContactById(@NonNull Long id) {
        return ResponseEntity.ok(contactMapper.convertToContactDTO(contactService.getContact(id)));
    }
}
