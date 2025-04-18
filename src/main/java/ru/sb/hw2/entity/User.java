package ru.sb.hw2.entity;


import lombok.*;
import ru.sb.hw2.repository.RoleRepository;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {


    private Long id;

    private String firstName;

    private String lastName;

    private Role role;

    private static final RoleRepository roleRepository = RoleRepository.getInstance();

    public User(String firstName, String lastName, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }
}
