package com.project.CourseLearningChallenges.Challenge3.service;

import com.project.CourseLearningChallenges.Challenge3.model.Review;
import com.project.CourseLearningChallenges.CourseLearningChallengesApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements ReviewService {

    private Map<Long, Review> map = CourseLearningChallengesApplication.getReviewMap();

    @Override
    public Review getReview(Long userID) {
        return map.getOrDefault(userID, null);
    }

    @Override
    public boolean addReview(Review review) {
        if(map.containsKey(review.getUserID()))
            return false;
        map.put(review.getUserID(), review);
        return true;
    }

    @Override
    public boolean updateReview(Long userID, Review review) {
        if(!map.containsKey(userID))
            return false;
        map.remove(userID);
        map.put(userID, review);
        return true;
    }

    @Override
    public void deleteReview(Long userID) {
        map.remove(userID);
    }

    @Override
    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        map.forEach((id, review) -> reviews.add(review));
        return reviews;
    }
}
