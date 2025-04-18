package ru.sb.hw2.controller;

import ru.sb.hw2.dto.UserDTO;
import ru.sb.hw2.entity.User;
import ru.sb.hw2.service.UserService;

import java.util.List;

public class UserController {

    private final UserService userService = UserService.getInstance();
    private static UserController instance;

    public static synchronized UserController getInstance() {
        if (instance == null) instance = new UserController();
        return instance;
    }

    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    public UserDTO findById(Long id) {
        return userService.findById(id);
    }

    public UserDTO save(User user) {
        return userService.save(user);
    }

    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    public UserDTO update(Long id, User user) {
        return userService.update(id, user);
    }
}
