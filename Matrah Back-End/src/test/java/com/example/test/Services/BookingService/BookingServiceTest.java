package com.example.test.Services.BookingService;

import com.example.demo.Entites.Booking;
import com.example.demo.Entites.User;
import com.example.demo.Entites.Venue;
import com.example.demo.Repositories.BookingRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Services.BookingService;
import com.example.demo.Services.VenueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private VenueService venueService;

    @InjectMocks
    private BookingService bookingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBookById() {
        Booking booking = new Booking();
        booking.setId(1);
        when(bookingRepository.findById(1)).thenReturn(Optional.of(booking));

        Booking result = bookingService.getBookById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testGetUserBookings() {
        User user = new User();
        user.setId(1);
        Booking booking1 = new Booking();
        Booking booking2 = new Booking();
        when(userRepository.findById(1)).thenReturn(user);
        when(bookingRepository.findBookingsByUser(user)).thenReturn(Arrays.asList(booking1, booking2));

        List<Booking> result = bookingService.getUserBookings(1);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetVenueBookings() {
        Venue venue = new Venue();
        venue.setId(1);
        Booking booking1 = new Booking();
        Booking booking2 = new Booking();
        when(venueService.getVenueById(1)).thenReturn(venue);
        when(bookingRepository.findBookingsByVenue(venue)).thenReturn(Arrays.asList(booking1, booking2));

        List<Booking> result = bookingService.getVenueBookings(1);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetBooksBetween() {
        Booking booking1 = new Booking();
        Booking booking2 = new Booking();
        Date startDate = new Date(2022, 1, 1);
        Date endDate = new Date(2022, 12, 31);
        when(bookingRepository.findBookingsByBookingDateBetween(startDate, endDate)).thenReturn(Arrays.asList(booking1, booking2));

        List<Booking> result = bookingService.getBooksBetween(startDate, endDate);
        assertEquals(2, result.size());
    }

    @Test
    public void testCreateNewBook() {
        Booking booking = new Booking();
        booking.setStatus(Booking.Status.CONFIRMED);
        when(bookingRepository.save(booking)).thenReturn(booking);

        Booking result = bookingService.createNewBook(booking);
        assertEquals(Booking.Status.CONFIRMED, result.getStatus());
    }

    @Test
    public void testConfirmBooking() {
        Booking booking = new Booking();
        booking.setId(1);
        when(bookingRepository.findById(1)).thenReturn(Optional.of(booking));

        bookingService.ConfirmBooking(1);
        assertEquals(Booking.Status.CONFIRMED, booking.getStatus());
    }

    @Test
    public void testCancelBooking() {
        Booking booking = new Booking();
        booking.setId(1);
        when(bookingRepository.findById(1)).thenReturn(Optional.of(booking));

        bookingService.CancelBooking(1);
        assertEquals(Booking.Status.CANCELLED, booking.getStatus());
    }

    @Test
    public void testCompleteBooking() {
        Booking booking = new Booking();
        booking.setId(1);
        when(bookingRepository.findById(1)).thenReturn(Optional.of(booking));

        bookingService.CompleteBooking(1);
        assertEquals(Booking.Status.COMPLETED, booking.getStatus());
    }
}
