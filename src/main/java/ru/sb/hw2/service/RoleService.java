package ru.sb.hw2.service;

import lombok.RequiredArgsConstructor;
import ru.sb.hw2.entity.Role;
import ru.sb.hw2.repository.RoleRepository;

import java.util.List;

@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository = RoleRepository.getInstance();
    private static RoleService instance;

    public static synchronized RoleService getInstance() {
        if (instance == null) instance = new RoleService();
        return instance;
    }


    public Role findById(Long id) {
        if(roleRepository.findById(id).isPresent()) {
            return roleRepository.findById(id).get();
        }
        throw new RuntimeException("Role not found");
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public void save(Role role) {
        roleRepository.save(role);
    }

    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

}
