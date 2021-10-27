package com.project.CourseLearningChallenges.Challenge4.repository;

import com.project.CourseLearningChallenges.Challenge4.config.ConnectionFactory;
import com.project.CourseLearningChallenges.Challenge4.constants.SQLQuery;
import com.project.CourseLearningChallenges.Challenge4.model.Rating;
import com.project.CourseLearningChallenges.Challenge4.model.Review;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewDAOImpl implements ReviewDAO {

    @Override
    public Optional<Review> getReview(Long userID) {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLQuery.FIND_REVIEW)) {

            statement.setLong(1, userID);
            ResultSet rs = statement.executeQuery();

            if(rs.next())
                return Optional.of(parseReviewFromRS(rs));

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();) {

            ResultSet rs = statement.executeQuery(SQLQuery.GET_ALL_REVIEWS);

            while(rs.next())
                reviews.add(parseReviewFromRS(rs));
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return reviews;
    }

    @Override
    public boolean addReview(Review review) {
        if(!getReview(review.getUserID()).isEmpty())
            return false;

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLQuery.ADD_REVIEW);) {

            statement.setLong(1, review.getUserID());
            statement.setString(2, review.getUserName());
            statement.setString(3, review.getRating().toString());

            statement.execute();
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateReview(Long userID, Review review) {
        if(getReview(review.getUserID()).isEmpty())
            return false;

        deleteReview(userID);
        return addReview(review);
    }

    @Override
    public void deleteReview(Long userID) {
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLQuery.DELETE_REVIEW);) {

            statement.setLong(1, userID);
            statement.execute();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private Review parseReviewFromRS(ResultSet rs) throws SQLException {
        Review review = new Review();
        review.setUserID(rs.getLong(1));
        review.setUserName(rs.getString(2));
        review.setRating(Rating.getRating(rs.getString(3)));
        return review;
    }
}
