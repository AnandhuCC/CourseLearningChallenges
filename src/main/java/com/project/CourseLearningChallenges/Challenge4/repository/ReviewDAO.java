package com.project.CourseLearningChallenges.Challenge4.repository;

import com.project.CourseLearningChallenges.Challenge4.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewDAO {

    Optional<Review> getReview(Long userID);

    List<Review> getAllReviews();

    boolean addReview(Review review);

    boolean updateReview(Long userID, Review review);

    void deleteReview(Long userID);
}
