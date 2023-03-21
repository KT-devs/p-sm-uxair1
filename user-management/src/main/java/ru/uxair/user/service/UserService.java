package ru.uxair.user.service;

import ru.uxair.user.entity.User;

public interface UserService {
    void updateUserData(Long id, User user);
}
