package ru.sb.hw2.service;

import lombok.RequiredArgsConstructor;
import ru.sb.hw2.dto.UserDTO;
import ru.sb.hw2.entity.User;
import ru.sb.hw2.mapper.UserMapper;
import ru.sb.hw2.repository.UserRepository;

import java.util.List;


@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository = UserRepository.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();
    private static UserService instance;

    public static synchronized UserService getInstance() {
        if(instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public UserDTO findById(Long id) {
        if(userRepository.findById(id).isPresent()) {
            return userMapper.toUserDTO(userRepository.findById(id).get());
        }
        throw new RuntimeException("User not found");
    }

    public List<UserDTO> findAll() {
        return userRepository.
                findAll()
                .stream()
                .map(userMapper::toUserDTO)
                .toList();

    }

    public UserDTO save(User user) {
        return userMapper.toUserDTO(userRepository.save(user));
    }

    public UserDTO update(Long id, User user) {
        return userMapper.toUserDTO(userRepository.update(id, user));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public Long getRoleIdByUserId(Long id) {
        return userRepository.getRoleIdByUserId(id);
    }

}
