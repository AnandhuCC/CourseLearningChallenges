package com.project.CourseLearningChallenges;

import com.project.CourseLearningChallenges.Challenge3.model.Review;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class CourseLearningChallengesApplication {

	private static Map<Long, Review> reviewMap = new HashMap<>();

	public static Map<Long, Review> getReviewMap() {
		return reviewMap;
	}

	public static void main(String[] args) {
		SpringApplication.run(CourseLearningChallengesApplication.class, args);
	}

}
