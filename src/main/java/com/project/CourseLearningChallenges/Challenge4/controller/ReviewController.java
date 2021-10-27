package com.project.CourseLearningChallenges.Challenge4.controller;

import com.project.CourseLearningChallenges.Challenge4.model.Review;
import com.project.CourseLearningChallenges.Challenge4.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/db/reviews")
@Component("reviewControllerDB")
public class ReviewController {

    @Autowired
    private ReviewService serviceDB;

    @GetMapping("/all")
    public ResponseEntity<List<Review>> listAllReviews() {
        List<Review> reviews = serviceDB.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<?> getReview(@PathVariable("id") Long userID) {
        Optional<Review> optional = serviceDB.getReview(userID);
        if(optional.isEmpty())
            return new ResponseEntity<>(new Exception(String.format("Review by user %d was not found.", userID)), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> createReview(@RequestBody Review review) {
        boolean flag = serviceDB.addReview(review);
        if(flag)
            return new ResponseEntity<>(String.format("Review by user %d has been posted.", review.getUserID()), HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(new Exception(String.format("Conflict. Review made by user %d exists already.", review.getUserID())), HttpStatus.CONFLICT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable("id") Long userID) {
        serviceDB.deleteReview(userID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
