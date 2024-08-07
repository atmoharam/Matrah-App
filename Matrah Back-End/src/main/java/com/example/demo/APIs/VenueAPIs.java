package com.example.demo.APIs;

import com.example.demo.DTOs.VenueCreationDTO;
import com.example.demo.Entites.Venue;
import com.example.demo.Services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ven")
public class VenueAPIs {
    @Autowired
    private VenueService venueService;

    @PostMapping("/")
    private ResponseEntity<Venue> createVenue(@RequestBody VenueCreationDTO venueCreationDTO){
        Venue savedVenue = venueService.createVenue(venueCreationDTO);
        return ResponseEntity.ok(savedVenue);
    }

    @GetMapping("/{venueId}")
    private ResponseEntity<Venue> getVenueById(@PathVariable int venueId){
        Venue venue = venueService.getVenueById(venueId);
        if(venue != null){
            return ResponseEntity.ok(venue);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("name/{venueName}")
    private ResponseEntity<Venue> getVenueByName(@PathVariable String venueName){
        Venue venue = venueService.getVenueByName(venueName);
        if(venue != null){
            return ResponseEntity.ok(venue);
        }
        return ResponseEntity.notFound().build();
    }

        @GetMapping("/all")
        public ResponseEntity<Page<Venue>> getAll(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
            return ResponseEntity.ok(venueService.getAllVenues(page, size));
        }

    @GetMapping("city/{cityId}")
    private ResponseEntity<List<Venue>> getByCityId(@PathVariable int cityId){
        return ResponseEntity.ok(venueService.getAllVenuesByCity(cityId));
    }

    @PostMapping("/suspend/{venueId}")
    private ResponseEntity<Venue> suspendVenue(@PathVariable int venueId){
        return ResponseEntity.ok(venueService.suspendVenue(venueId));
    }

}
