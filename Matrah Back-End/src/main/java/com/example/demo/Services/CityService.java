package com.example.demo.Services;

import com.example.demo.Entites.City;
import com.example.demo.Repositories.CityRepository;
import com.example.demo.Services.Interfaces.CityServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityService implements CityServiceI {
    @Autowired
    CityRepository cityRepository;
    @Override
    public City getCityById(int id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public City getCityByName(String cityName) {
        return cityRepository.findByName(cityName);
    }

    @Override
    public List<City> getAllCities() {
        return (List<City>) cityRepository.findAll();
    }

    @Override
    public City createNewCity(City _city) {
        return cityRepository.save(_city);
    }

    @Override
    public City updateCity(int id, City _city) {
        if(cityRepository.existsById(id)){
            City oldCity = cityRepository.findById(id).orElse(null);
            oldCity.setName(_city.getName());
            cityRepository.save(oldCity);
            return oldCity;
        }
        return null;
    }

    @Override
    public boolean deleteCity(int id) {
        if(cityRepository.existsById(id)){
            cityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
