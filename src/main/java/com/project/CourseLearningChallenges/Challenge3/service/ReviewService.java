package com.project.CourseLearningChallenges.Challenge3.service;

import com.project.CourseLearningChallenges.Challenge3.model.Review;

import java.util.List;

public interface ReviewService {

    Review getReview(Long userID);

    boolean addReview(Review review);

    boolean updateReview(Long userID, Review review);

    void deleteReview(Long userID);

    List<Review> getAllReviews();
}
