package com.project.CourseLearningChallenges.Challenge4.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String userName = "postgres";
    private static final String password = "Admin@123";
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
