package com.example.demo.Services.Interfaces;

import com.example.demo.Entites.Area;
import com.example.demo.Entites.City;

import java.util.List;

public interface AreaServiceI {
    public Area getAreaById(int id);
    public Area getAreaByName(String areaName);
    public List<Area> getAllAreas();
    public Area createNewArea(Area area, int city_id);
    public Area updateArea(int id , Area _area);
    public boolean deleteArea(int id);
}
