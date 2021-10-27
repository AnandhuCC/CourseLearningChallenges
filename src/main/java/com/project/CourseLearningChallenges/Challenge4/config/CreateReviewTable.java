package com.project.CourseLearningChallenges.Challenge4.config;

import com.project.CourseLearningChallenges.Challenge4.constants.SQLQuery;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateReviewTable {

    public static void main(String[] args) {
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();) {

            statement.execute(SQLQuery.CREATE_TABLE);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
