package crisci.caterina.goodstream.service;

import crisci.caterina.goodstream.DTO.ReviewDTO;
import crisci.caterina.goodstream.exceptions.NotFoundException;
import crisci.caterina.goodstream.models.Review;
import crisci.caterina.goodstream.models.User;
import crisci.caterina.goodstream.repository.ReviewRepository;
import crisci.caterina.goodstream.repository.TitleRepository;
import crisci.caterina.goodstream.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TitleRepository titleRepository;

    public Review save(ReviewDTO reviewDTO) {
        if (!userRepository.existsById(reviewDTO.userId())) {
            throw new NotFoundException(reviewDTO.userId());
        }

        if (!titleRepository.existsById(reviewDTO.titleId())) {
            throw new NotFoundException(reviewDTO.titleId());

        }
        User author = userRepository.findById(reviewDTO.userId()).orElseThrow();
        author.getReviews().add(reviewDTO)
        return reviewRepository.save(Review.);

    }

    public Review update(Review review, UUID reviewId) {
        if (!reviewId.equals(review.getId()) || !reviewRepository.existsById(reviewId)) {
            throw new NotFoundException(reviewId);
        }
        return reviewRepository.save(review);
    }

    public Review getById(UUID reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow(() -> new NotFoundException(reviewId));
    }

    public List<Review> getAllByTitle(UUID titleId) {
        return reviewRepository.findByTitleId(titleId);
    }

    public List<Review> getAllByUser(UUID userId) {
        return reviewRepository.findByUserId(userId);
    }

    public void delete(UUID reviewId) {
        reviewRepository.deleteById(reviewId);
    }

}
