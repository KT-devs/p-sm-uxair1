package ru.uxair.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.uxair.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
