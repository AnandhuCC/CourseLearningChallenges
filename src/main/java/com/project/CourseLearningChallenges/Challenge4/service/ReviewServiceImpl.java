package com.project.CourseLearningChallenges.Challenge4.service;

import com.project.CourseLearningChallenges.Challenge4.model.Review;
import com.project.CourseLearningChallenges.Challenge4.repository.ReviewDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("serviceDB")
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewDAOImpl reviewDAO;


    @Override
    public Optional<Review> getReview(Long userID) {
        return reviewDAO.getReview(userID);
    }

    @Override
    public boolean addReview(Review review) {
        return reviewDAO.addReview(review);
    }

    @Override
    public boolean updateReview(Long userID, Review review) {
        return reviewDAO.updateReview(userID, review);
    }

    @Override
    public void deleteReview(Long userID) {
        reviewDAO.deleteReview(userID);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewDAO.getAllReviews();
    }
}
