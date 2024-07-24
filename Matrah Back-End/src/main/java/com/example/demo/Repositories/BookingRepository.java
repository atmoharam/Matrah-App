package com.example.demo.Repositories;

import com.example.demo.Entites.Booking;
import com.example.demo.Entites.User;
import com.example.demo.Entites.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking , Integer> {
    public List<Booking> findBookingsByUser(User _user);
    public List<Booking> findBookingsByVenue(Venue _venue);
    public List<Booking> findBookingsByBookingDateBetween(Date startDate, Date endDate);
}
