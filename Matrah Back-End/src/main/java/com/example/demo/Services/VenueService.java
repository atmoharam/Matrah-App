package com.example.demo.Services;

import com.example.demo.DTOs.VenueCreationDTO;
import com.example.demo.Entites.Area;
import com.example.demo.Entites.City;
import com.example.demo.Entites.User;
import com.example.demo.Entites.Venue;
import com.example.demo.Repositories.AreaRepository;
import com.example.demo.Repositories.CityRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Repositories.VenueRepository;
import com.example.demo.Services.Interfaces.VenueServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService implements VenueServiceI {

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AreaRepository areaRepository;

    @Override
    public Venue getVenueById(int id) {
        return venueRepository.findById(id).orElse(null);
    }

    @Override
    public Venue getVenueByName(String name) {
        return venueRepository.findByNameAndIsSuspended(name,false);
    }

    @Override
    public List<Venue> getAllVenues() {
        return (List<Venue>) venueRepository.findAll();
    }

    @Override
    public Venue createVenue(VenueCreationDTO venue) {
        User owner = userRepository.findById(venue.getOwnerId());
        City city = cityRepository.findById(venue.getCityId()).orElse(null);
        Area area = areaRepository.findById(venue.getAreaId()).orElse(null);
        Venue venue1 = new Venue(venue.getName(), venue.getDescription(),venue.getCategory(),venue.getAddress(),owner,city,area);
        return venueRepository.save(venue1);
    }

    @Override
    public Venue updateVenue(int id, Venue _venue) {
        Venue old = venueRepository.findById(id).orElse(null);
        if(old != null){
            old.setName(_venue.getName());
            old.setArea(_venue.getArea());
            old.setDescription(_venue.getDescription());
            venueRepository.save(old);
            return old;
        }
        return null;
    }

    @Override
    public List<Venue> getAllVenuesByCity(int cityId) {
        City city = cityRepository.findById(cityId).orElse(null);
        if(city != null){
            return venueRepository.findVenuesByCity(city);
        }
        return null;
    }

    @Override
    public Venue suspendVenue(int id) {
        Venue old = venueRepository.findById(id).orElse(null);
        if(old != null){
            old.setSuspended(!old.isSuspended());
            return venueRepository.save(old);
        }
        return null;
    }

    @Override
    public boolean deleteVenue(int id) {
        Venue venue = venueRepository.findById(id).orElse(null);
        if(venue != null){
            venueRepository.delete(venue);
            return true;
        }
        return false;
    }
}
