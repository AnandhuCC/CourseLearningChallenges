package com.project.CourseLearningChallenges.Challenge3.model;

public enum Rating {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private int rating;

    private Rating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}
