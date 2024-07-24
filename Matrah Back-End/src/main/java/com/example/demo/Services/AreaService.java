package com.example.demo.Services;

import com.example.demo.Entites.Area;
import com.example.demo.Entites.City;
import com.example.demo.Repositories.AreaRepository;
import com.example.demo.Repositories.CityRepository;
import com.example.demo.Services.Interfaces.AreaServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService implements AreaServiceI {

    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private CityRepository cityRepository;
    @Override
    public Area getAreaById(int id) {
        return areaRepository.findById(id).orElse(null);
    }

    @Override
    public Area getAreaByName(String areaName) {
        return areaRepository.findByName(areaName);
    }

    @Override
    public List<Area> getAllAreas() {
        return (List<Area>) areaRepository.findAll();
    }

    @Override
    public Area createNewArea(Area area, int cityId) {
        area.setCity(cityRepository.findById(cityId).orElse(null));
        return areaRepository.save(area);
    }

    @Override
    public Area updateArea(int id, Area _area) {
        if(areaRepository.existsById(id)){
            Area oldArea = areaRepository.findById(id).orElse(null);
            oldArea.setName(_area.getName());
            areaRepository.save(oldArea);
            return oldArea;
        }
        return null;
    }

    @Override
    public boolean deleteArea(int id) {
        if(areaRepository.existsById(id)){
            areaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
