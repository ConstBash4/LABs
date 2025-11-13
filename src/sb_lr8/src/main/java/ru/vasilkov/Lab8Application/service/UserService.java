package ru.vasilkov.Lab8Application.service;

import ru.vasilkov.Lab8Application.dto.UserDto;
import ru.vasilkov.Lab8Application.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
