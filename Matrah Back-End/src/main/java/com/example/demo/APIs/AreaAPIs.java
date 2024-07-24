package com.example.demo.APIs;

import com.example.demo.Entites.Area;
import com.example.demo.Entites.City;
import com.example.demo.Services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaAPIs {
    @Autowired
    private AreaService areaService;

    @GetMapping("/{id}")
    public ResponseEntity<Area> getCityById(@PathVariable int id) {
        Area area = areaService.getAreaById(id);
        if (area != null) {
            return ResponseEntity.ok(area);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Area> getCityByName(@PathVariable String name) {
        Area area = areaService.getAreaByName(name);
        if (area != null) {
            return ResponseEntity.ok(area);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Area>> getAllCities() {
        List<Area> areas = areaService.getAllAreas();
        return ResponseEntity.ok(areas);
    }

    @PostMapping("/create/{city_id}")
    public ResponseEntity<Area> createNewCity(@RequestBody Area area, @PathVariable int city_id) {
        Area createdArea = areaService.createNewArea(area, city_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Area> updateCity(@PathVariable int id, @RequestBody Area area) {
        Area updatedArea = areaService.updateArea(id, area);
        if (updatedArea != null) {
            return ResponseEntity.ok(updatedArea);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable int id) {
        boolean deleted = areaService.deleteArea(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
