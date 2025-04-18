package ru.sb.hw2.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.sb.hw2.controller.UserController;
import ru.sb.hw2.dto.UserDTO;
import ru.sb.hw2.entity.User;
import ru.sb.hw2.mapper.UserMapper;
import ru.sb.hw2.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/users/*"})
public class UserServlet extends HttpServlet {

    private final UserController userController = UserController.getInstance();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final UserMapper userMapper = UserMapper.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if(pathInfo == null && pathInfo.isEmpty()) {
            List<UserDTO> users = userController.findAll();
            resp.setContentType("application/json");
            resp.getWriter().write(objectMapper.writeValueAsString(users));
        }
        else {
            Long id = Long.parseLong(pathInfo.substring(1));
            UserDTO user = userController.findById(id);
            if(user != null) {
                resp.setContentType("application/json");
                resp.getWriter().write(objectMapper.writeValueAsString(user));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userOut = objectMapper.readValue(req.getInputStream(), UserDTO.class);
        UserDTO newUser = userController.save(userMapper.toUserEntity(userOut));
        resp.setContentType("application/json");
        resp.getWriter().write(objectMapper.writeValueAsString(newUser));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userOut = objectMapper.readValue(req.getInputStream(), UserDTO.class);
        UserDTO newUser = userController.update(userOut.getId(), userMapper.toUserEntity(userOut));
        if(newUser != null) {
            resp.setContentType("application/json");
            resp.getWriter().write(objectMapper.writeValueAsString(newUser));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        Long id = Long.parseLong(pathInfo.substring(1));
        userController.deleteById(id);
    }
}
