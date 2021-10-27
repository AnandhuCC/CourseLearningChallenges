package com.project.CourseLearningChallenges.Challenge4.constants;

public class SQLQuery {

    public static final String CREATE_TABLE = "CREATE TABLE reviews " +
            "(userID INTEGER NOT NULL, " +
            "NAME VARCHAR(255), " +
            "RATING VARCHAR(255) NOT NULL," +
            "PRIMARY KEY (userID))";

    public static final String FIND_REVIEW = "SELECT * FROM reviews WHERE userID=?";

    public static final String GET_ALL_REVIEWS = "SELECT * FROM reviews";

    public static final String ADD_REVIEW = "INSERT INTO reviews VALUES (?, ?, ?)";

    public static final String DELETE_REVIEW = "DELETE FROM reviews WHERE userID=?";
}
