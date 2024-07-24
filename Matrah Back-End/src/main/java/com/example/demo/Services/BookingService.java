package com.example.demo.Services;

import com.example.demo.Entites.Booking;
import com.example.demo.Entites.User;
import com.example.demo.Entites.Venue;
import com.example.demo.Repositories.BookingRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Services.Interfaces.BookingServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingService implements BookingServiceI {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired VenueService venueService;
    @Override
    public Booking getBookById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Booking> getUserBookings(int userId) {
        User user = userRepository.findById(userId);
        if(null != user){
            return bookingRepository.findBookingsByUser(user);
        }
        return null;
    }

    @Override
    public List<Booking> getVenueBookings(int venueId) {
        Venue venue = venueService.getVenueById(venueId);
        if(null!= venue){
            return bookingRepository.findBookingsByVenue(venue);
        }
        return null;
    }

    @Override
    public List<Booking> getBooksBetween(Date start, Date until) {
        return bookingRepository.findBookingsByBookingDateBetween(start , until);
    }

    @Override
    public Booking createNewBook(Booking _book) {
        return bookingRepository.save(_book);
    }

    @Override
    public void ConfirmBooking(int id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if(booking !=null){
            booking.setStatus(Booking.Status.CONFIRMED);
        }
    }

    @Override
    public void CancelBooking(int id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if(booking !=null){
            booking.setStatus(Booking.Status.CANCELLED);
        }
    }

    @Override
    public void CompleteBooking(int id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if(booking !=null){
            booking.setStatus(Booking.Status.COMPLETED);
        }
    }
}
