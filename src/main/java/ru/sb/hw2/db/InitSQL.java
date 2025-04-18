package ru.sb.hw2.db;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;

public class InitSQL {

    private static String schemaSql;

    public static void loadInitSQL() {
        try (InputStream inFile = InitSQL.class.getClassLoader().getResourceAsStream("init.sql");
             Connection connection = DbUtils.getConnection();
             Statement statement = connection.createStatement()) {
            schemaSql = new String(inFile.readAllBytes(), StandardCharsets.UTF_8);
            statement.execute(schemaSql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
