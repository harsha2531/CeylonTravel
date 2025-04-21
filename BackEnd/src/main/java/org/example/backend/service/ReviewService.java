package org.example.backend.service;

import org.example.backend.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

        public Review saveReview(Review review);

        public List<Review> getAllReviews();

        public Optional<Review> getReviewById(Long id);

        public Review updateReview(Review review) ;

        public void deleteReview(Long id);
    }

