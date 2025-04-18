package ru.sb.hw2.repository;

import lombok.NoArgsConstructor;
import ru.sb.hw2.db.DbUtils;
import ru.sb.hw2.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@NoArgsConstructor
public class UserRepository {

    private static final String SAVE_USER = "INSERT INTO users (first_name, last_name, role_id) VALUES (?, ?, ?);";
    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?;";
    private static final String UPDATE_USER = "UPDATE users SET first_name = ?, last_name = ?, role_id = ? WHERE id = ?;";
    private static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?;";
    private static final String GET_ALL_USERS = "SELECT * FROM users;";
    private static final String GET_ROLE_ID_BY_USER_ID = "SELECT role_id FROM users WHERE id = ?;";

    private static UserRepository instance;
    private final RoleRepository roleRepository = RoleRepository.getInstance();

    public static synchronized UserRepository getInstance() {
        if (instance == null) instance = new UserRepository();
        return instance;
    }


    public Long getRoleIdByUserId(Long id) {
        try (Connection connection = DbUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLE_ID_BY_USER_ID)) {

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return resultSet.getLong("role_id");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Optional<User> findById (Long id) {
        User user = null;
        try (Connection connection = DbUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID)) {

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) user = createUser(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) users.add(createUser(resultSet));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    public User save(User user) {
        try (Connection connection = DbUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER)) {

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setLong(3, user.getRole().getId());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) user = createUser(resultSet);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void deleteById(Long id) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public User update(Long id, User user) {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setLong(3, user.getRole().getId());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    private User createUser(ResultSet resultSet) throws SQLException {

            return new User(
                    resultSet.getLong("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    roleRepository.findById(resultSet.getLong("role_id")).get()
            );
    }

}
