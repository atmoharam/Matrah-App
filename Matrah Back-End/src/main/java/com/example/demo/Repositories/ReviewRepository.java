package com.example.demo.Repositories;

import com.example.demo.Entites.Reviews;
import com.example.demo.Entites.User;
import com.example.demo.Entites.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Reviews, Integer> {
    public List<Reviews> findReviewsByUser(User user);
    public List<Reviews> findReviewsByVenue(Venue venue);
}
