package ru.sb.hw2.entity;

import lombok.*;
import ru.sb.hw2.repository.UserRepository;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private Long id;
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    private static final UserRepository userRepository = UserRepository.getInstance();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("id=").append(id);
        sb.append(", roleName='").append(roleName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
