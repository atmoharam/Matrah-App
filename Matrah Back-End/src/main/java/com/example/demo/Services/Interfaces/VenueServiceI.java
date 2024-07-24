package com.example.demo.Services.Interfaces;

import com.example.demo.DTOs.VenueCreationDTO;
import com.example.demo.Entites.City;
import com.example.demo.Entites.User;
import com.example.demo.Entites.Venue;

import java.util.List;

public interface VenueServiceI {
    public Venue getVenueById(int id);
    public Venue getVenueByName(String name);
    public List<Venue> getAllVenues();
    public Venue createVenue(VenueCreationDTO venue);
    public Venue updateVenue(int id , Venue _venue);
    public List<Venue> getAllVenuesByCity(int cityId);
    public Venue suspendVenue(int id);
    public boolean deleteVenue(int id);
}
