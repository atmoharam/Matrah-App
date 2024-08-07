package com.example.test.Services.ReviewService;

import com.example.demo.Entites.Reviews;
import com.example.demo.Entites.User;
import com.example.demo.Entites.Venue;
import com.example.demo.Repositories.ReviewRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Repositories.VenueRepository;
import com.example.demo.Services.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private VenueRepository venueRepository;

    @InjectMocks
    private ReviewService reviewService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetReviewsById() {
        Reviews review = new Reviews();
        review.setId(1);
        when(reviewRepository.findById(1)).thenReturn(Optional.of(review));

        Reviews result = reviewService.getReviewsById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testGetUserReviews() {
        User user = new User();
        user.setId(1);
        Reviews review1 = new Reviews();
        Reviews review2 = new Reviews();
        when(userRepository.findById(1)).thenReturn(user);
        when(reviewRepository.findReviewsByUser(user)).thenReturn(Arrays.asList(review1, review2));

        List<Reviews> result = reviewService.getUserReviews(1);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetVenueReviews() {
        Venue venue = new Venue();
        venue.setId(1);
        Reviews review1 = new Reviews();
        Reviews review2 = new Reviews();
        when(venueRepository.findById(1)).thenReturn(Optional.of(venue));
        when(reviewRepository.findReviewsByVenue(venue)).thenReturn(Arrays.asList(review1, review2));

        List<Reviews> result = reviewService.getVenueReviews(1);
        assertEquals(2, result.size());
    }

    @Test
    public void testCreateNewReview() {
        Reviews review = new Reviews();
        review.setRating(5);
        when(reviewRepository.save(review)).thenReturn(review);

        Reviews result = reviewService.createNewBook(review);
        assertEquals(5, result.getRating());
    }

    // Add more tests for other methods as needed
}
