package com.example.demo.Repositories;

import com.example.demo.Entites.City;
import com.example.demo.Entites.Venue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends CrudRepository<Venue , Integer>{
    public Venue findByNameAndIsSuspended(String name,boolean isSuspended);
    public Venue findByCategory(String category);
    Page<Venue> findAll(Pageable pageable);
    public List<Venue> findVenuesByCity(City city);




}
