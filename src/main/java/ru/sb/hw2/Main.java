package ru.sb.hw2;

import ru.sb.hw2.db.DbUtils;
import ru.sb.hw2.db.InitSQL;
import ru.sb.hw2.entity.Role;
import ru.sb.hw2.entity.User;
import ru.sb.hw2.repository.RoleRepository;
import ru.sb.hw2.repository.UserRepository;
import ru.sb.hw2.service.RoleService;
import ru.sb.hw2.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DbUtils.getConnection();
        InitSQL.loadInitSQL();

        UserService userService = UserService.getInstance();
        RoleService roleService = RoleService.getInstance();

        System.out.println(userService.findAll() + " Все пользователи");
        System.out.println(userService.findById(2L) + " Пользователь по id2");
        System.out.println(userService.update(2L, new User("Vasya", "Pupkin", roleService.findById(userService.getRoleIdByUserId(2L)))) + " Обновление пользователя");
        System.out.println(userService.findAll() + " Все пользователи после обновления");

        System.out.println("+===================+");
        userService.deleteById(2L);
        System.out.println(userService.findAll() + " Все пользователи после удаления");
        System.out.println(userService.save(new User("Gena", "Jopkin", roleService.findById(2L))) + " Добавление пользователя");
        System.out.println(userService.findAll() + " Все пользователи после добавления");




    }
}
