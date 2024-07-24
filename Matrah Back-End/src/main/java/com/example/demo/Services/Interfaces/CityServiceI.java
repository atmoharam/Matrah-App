package com.example.demo.Services.Interfaces;

import com.example.demo.Entites.City;
import com.example.demo.Entites.User;

import java.util.List;

public interface CityServiceI {
    public City getCityById(int id);
    public City getCityByName(String cityName);
    public List<City> getAllCities();
    public City createNewCity(City _city);
    public City updateCity(int id , City _city);
    public boolean deleteCity(int id);
}
