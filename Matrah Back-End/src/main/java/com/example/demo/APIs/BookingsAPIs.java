package com.example.demo.APIs;

import com.example.demo.Entites.Booking;
import com.example.demo.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingsAPIs {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        return ResponseEntity.ok(bookingService.createNewBook(booking));
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Booking> getById(@PathVariable int id){
        return ResponseEntity.ok(bookingService.getBookById(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Booking>> getUserBooks(@PathVariable int id){
        return ResponseEntity.ok(bookingService.getUserBookings(id));
    }
    @GetMapping("/venue/{id}")
    public ResponseEntity<List<Booking>> getVenueBooks(@PathVariable int id){
        return ResponseEntity.ok(bookingService.getVenueBookings(id));
    }

    @PutMapping("/confirm/{id}")
    public ResponseEntity<?> confirmBooking(@PathVariable int id){
        bookingService.ConfirmBooking(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable int id){
        bookingService.CancelBooking(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/complete/{id}")
    public ResponseEntity<?> completeBooking(@PathVariable int id){
        bookingService.CompleteBooking(id);
        return ResponseEntity.accepted().build();
    }

}
