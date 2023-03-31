package ru.uxair.user.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.uxair.user.entity.dto.UserDto;
import ru.uxair.user.service.UserService;
import ru.uxair.user.util.mapper.UserMapper;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public ResponseEntity<HttpStatus> updateUserDataById(@NonNull Long id, @NonNull UserDto userDto) {
        userService.updateUserData(id, userMapper.convertToUser(userDto));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
