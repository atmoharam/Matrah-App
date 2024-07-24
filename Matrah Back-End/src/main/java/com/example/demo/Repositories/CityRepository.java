package com.example.demo.Repositories;

import com.example.demo.Entites.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
    City findByName(String cityName);
}
