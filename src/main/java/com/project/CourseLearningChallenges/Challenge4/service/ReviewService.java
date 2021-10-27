package com.project.CourseLearningChallenges.Challenge4.service;

import com.project.CourseLearningChallenges.Challenge4.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    Optional<Review> getReview(Long userID);

    boolean addReview(Review review);

    boolean updateReview(Long userID, Review review);

    void deleteReview(Long userID);

    List<Review> getAllReviews();
}
