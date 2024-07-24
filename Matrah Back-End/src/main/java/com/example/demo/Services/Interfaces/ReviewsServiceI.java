package com.example.demo.Services.Interfaces;


import com.example.demo.Entites.Reviews;

import java.util.Date;
import java.util.List;

public interface ReviewsServiceI {
    public Reviews getReviewsById(int id);
    public List<Reviews> getUserReviews(int userId);
    public List<Reviews> getVenueReviews(int venueId);
    public Reviews createNewBook(Reviews _review);
}
