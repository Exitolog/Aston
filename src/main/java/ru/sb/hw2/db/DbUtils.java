package ru.sb.hw2.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbUtils {

    private static final String URL = "jdbc:postgresql://localhost:5431/postgres?INIT=SCRIPT FROM 'classpath:init.sql'";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";


    public static Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;

    }

}
