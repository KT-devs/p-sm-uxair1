package ru.uxair.user.util.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.uxair.user.entity.Contact;
import ru.uxair.user.entity.dto.ContactDto;

@Component
@AllArgsConstructor
public class ContactMapper {
    private final ModelMapper modelMapper;

    public Contact convertToContact(ContactDto contactDto) {
        return modelMapper.map(contactDto, Contact.class);
    }

    public ContactDto convertToContactDTO(Contact contact) {
        return modelMapper.map(contact, ContactDto.class);
    }
}
