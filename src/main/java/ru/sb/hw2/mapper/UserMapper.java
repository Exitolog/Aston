package ru.sb.hw2.mapper;

import ru.sb.hw2.dto.UserDTO;
import ru.sb.hw2.entity.User;
import ru.sb.hw2.repository.RoleRepository;
import ru.sb.hw2.repository.UserRepository;
import ru.sb.hw2.service.UserService;

public class UserMapper {

    private final RoleRepository roleRepository = RoleRepository.getInstance();
    private final UserRepository userRepository = UserRepository.getInstance();
    private static UserMapper instance;

    public static synchronized UserMapper getInstance() {
        if (instance == null) instance = new UserMapper();
        return instance;
    }

    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setRole(user.getRole().getRoleName());
        return userDTO;
    }

    public User toUserEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setRole(roleRepository.findById(userRepository.getRoleIdByUserId(userDTO.getId())).get());
        return user;
    }
}
