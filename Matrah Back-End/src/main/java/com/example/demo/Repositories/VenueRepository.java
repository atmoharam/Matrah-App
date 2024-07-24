package com.example.demo.Repositories;

import com.example.demo.Entites.City;
import com.example.demo.Entites.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends CrudRepository<Venue , Integer>{
    public Venue findByNameAndIsSuspended(String name,boolean isSuspended);
    public Venue findByCategory(String category);

    public List<Venue> findVenuesByCity(City city);
}
