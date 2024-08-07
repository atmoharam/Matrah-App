package com.example.test.Services.VenueService;

import com.example.demo.DTOs.VenueCreationDTO;
import com.example.demo.Entites.Area;
import com.example.demo.Entites.City;
import com.example.demo.Entites.User;
import com.example.demo.Entites.Venue;
import com.example.demo.Repositories.AreaRepository;
import com.example.demo.Repositories.CityRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Repositories.VenueRepository;
import com.example.demo.Services.VenueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VenueServiceTest {

    @Mock
    private VenueRepository venueRepository;

    @Mock
    private CityRepository cityRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AreaRepository areaRepository;

    @InjectMocks
    private VenueService venueService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetVenueById() {
        Venue venue = new Venue();
        venue.setId(1);
        when(venueRepository.findById(1)).thenReturn(Optional.of(venue));

        Venue result = venueService.getVenueById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testGetVenueByName() {
        Venue venue = new Venue();
        venue.setName("Test Venue");
        when(venueRepository.findByNameAndIsSuspended("Test Venue", false)).thenReturn(venue);

        Venue result = venueService.getVenueByName("Test Venue");
        assertEquals("Test Venue", result.getName());
    }

    @Test
    public void testGetAllVenues() {
        Venue venue1 = new Venue();
        Venue venue2 = new Venue();
        Pageable pageable = PageRequest.of(0, 2);
        Page<Venue> page = new PageImpl<>(Arrays.asList(venue1, venue2), pageable, 2);
        when(venueRepository.findAll(pageable)).thenReturn(page);

        Page<Venue> result = venueService.getAllVenues(2, 0);
        assertEquals(2, result.getContent().size());
    }

    @Test
    public void testCreateVenue() {
        VenueCreationDTO dto = new VenueCreationDTO();
        dto.setName("Test Venue");
        dto.setDescription("Description");
        dto.setCategory("Category");
        dto.setAddress("Address");
        dto.setOwnerId(1);
        dto.setCityId(1);
        dto.setAreaId(1);

        User owner = new User();
        owner.setId(1);
        City city = new City();
        city.setId(1);
        Area area = new Area();
        area.setId(1);

        when(userRepository.findById(1)).thenReturn(owner);
        when(cityRepository.findById(1)).thenReturn(Optional.of(city));
        when(areaRepository.findById(1)).thenReturn(Optional.of(area));

        Venue venue = new Venue(dto.getName(), dto.getDescription(), dto.getCategory(), dto.getAddress(), owner, city, area);
        when(venueRepository.save(any(Venue.class))).thenReturn(venue);

        Venue result = venueService.createVenue(dto);
        assertEquals("Test Venue", result.getName());
    }

    // Add more tests for other methods as needed
}
