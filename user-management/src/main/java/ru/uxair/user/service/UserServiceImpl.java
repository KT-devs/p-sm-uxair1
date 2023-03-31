package ru.uxair.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.uxair.user.entity.User;
import ru.uxair.user.repository.UserRepository;
import ru.uxair.user.util.exceptions.ResourceNotFoundException;

@Repository
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void updateUserData(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            user.setUserName(user.getUserName());
            user.setContacts(user.getContacts());
            userRepository.save(user);
        } else {
            throw new ResourceNotFoundException("= " + id);
        }
    }
}
