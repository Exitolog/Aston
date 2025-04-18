package ru.sb.hw2.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sb.hw2.db.DbUtils;
import ru.sb.hw2.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class RoleRepository {

    private static final String SAVE_ROLE = "INSERT INTO roles (name) VALUES (?);";
    private static final String DELETE_ROLE_BY_ID = "DELETE FROM roles WHERE id = ?;";
    private static final String FIND_BY_ID = "SELECT * FROM roles WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM roles;";
//    private static final String FIND_ALL_USERS_BY_ROLE_ID = "SELECT * FROM users WHERE role_id = ?;";
//    private static final String DELETE_ROLE_BY_USER_ID = "DELETE FROM roles WHERE id = ?;";

    private static RoleRepository instance;
    private static UserRepository userRepository = UserRepository.getInstance();


    public static synchronized RoleRepository getInstance() {
        if (instance == null) instance = new RoleRepository();
        return instance;
    }

    public Optional<Role> findById(Long id) {
        Role role = null;
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                role = new Role(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(role);
    }

    public List<Role> findAll(){
        List<Role> roles = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                roles.add(createRole(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public Role save(Role role) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(SAVE_ROLE)) {
            statement.setString(1, role.getRoleName());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                createRole(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    public void deleteById(Long id) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ROLE_BY_ID)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Role createRole(ResultSet resultSet) throws SQLException {
        Role role =  new Role(
                resultSet.getLong("id"),
                resultSet.getString("name")
        );
        return role;
    }

}
