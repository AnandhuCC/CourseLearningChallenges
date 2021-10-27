package com.project.CourseLearningChallenges.Challenge3.controller;

import com.project.CourseLearningChallenges.Challenge3.model.Review;
import com.project.CourseLearningChallenges.Challenge3.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @GetMapping("/all")
    public ResponseEntity<List<Review>> listAllReviews() {
        List<Review> reviews = service.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<?> getReview(@PathVariable("id") Long userID) {
        Review review = service.getReview(userID);
        if(review == null)
            return new ResponseEntity<>(new Exception(String.format("Review by user %d was not found.", userID)), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> createReview(@RequestBody Review review) {
        boolean flag = service.addReview(review);
        if(flag)
            return new ResponseEntity<>(String.format("Review by user %d has been posted.", review.getUserID()), HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(new Exception(String.format("Conflict. Review made by user %d exists already.", review.getUserID())), HttpStatus.CONFLICT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable("id") Long userID) {
        service.deleteReview(userID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
