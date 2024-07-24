package com.example.demo.Repositories;

import com.example.demo.Entites.ServiceE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceE, Integer> {
    public ServiceE findByName(String name);
}
