package com.project.CourseLearningChallenges.Challenge4.model;

public class Review {

    private Long userID;
    private String userName;
    private Rating rating;

    public Review() {}

    public Review(Long userID, String userName, Rating rating) {
        this.userID = userID;
        this.userName = userName;
        this.rating = rating;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
