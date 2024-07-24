package com.example.demo.Repositories;

import com.example.demo.Entites.Area;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends CrudRepository<Area , Integer> {
    public Area findByName(String name);
}
