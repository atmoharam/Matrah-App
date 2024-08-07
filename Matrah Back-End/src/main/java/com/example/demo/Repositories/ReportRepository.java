package com.example.demo.Repositories;

import com.example.demo.Entites.Report;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ReportRepository extends CrudRepository<Report , Integer> {
    public List<Report> findAllByOwnerId(int id);
    public List<Report> findAllByUserId(int id);
}
