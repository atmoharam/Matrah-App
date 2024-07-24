package com.example.demo.Services;

import com.example.demo.Entites.Reviews;
import com.example.demo.Entites.User;
import com.example.demo.Entites.Venue;
import com.example.demo.Repositories.ReviewRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Repositories.VenueRepository;
import com.example.demo.Services.Interfaces.ReviewsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements ReviewsServiceI {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VenueRepository venueRepository;
    @Override
    public Reviews getReviewsById(int id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reviews> getUserReviews(int userId) {
        User user = userRepository.findById(userId);
        if(null != user){
            return reviewRepository.findReviewsByUser(user);
        }
        return null;
    }

    @Override
    public List<Reviews> getVenueReviews(int venueId) {
        Venue venue = venueRepository.findById(venueId).orElse(null);
        if(null != venue){
            return reviewRepository.findReviewsByVenue(venue);
        }
        return null;
    }

    @Override
    public Reviews createNewBook(Reviews _review) {
        return reviewRepository.save(_review);
    }
}
