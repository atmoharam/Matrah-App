package com.example.demo.Services.Interfaces;


import com.example.demo.Entites.Booking;

import java.util.Date;
import java.util.List;

public interface BookingServiceI {
    public Booking getBookById(int id);
    public List<Booking> getUserBookings(int userId);
    public List<Booking> getVenueBookings(int venueId);
    public List<Booking> getBooksBetween(Date start , Date until);
    public Booking createNewBook(Booking _book);
    public void ConfirmBooking(int id);
    public void CancelBooking(int id);
    public void CompleteBooking(int id);
}
