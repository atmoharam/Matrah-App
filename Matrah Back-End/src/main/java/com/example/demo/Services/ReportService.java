package com.example.demo.Services;

import com.example.demo.Entites.Report;
import com.example.demo.Repositories.ReportRepository;
import com.example.demo.Services.Interfaces.ReportServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReportService implements ReportServiceI {
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List<Report> getOwnerReports(int id) {
        return reportRepository.findAllByOwnerId(id);
    }

    @Override
    public List<Report> getUserReports(int id) {
        return reportRepository.findAllByUserId(id);
    }

    @Override
    public List<Report> getAllReports() {
        return (List<Report>) reportRepository.findAll();
    }

    @Override
    public void insertReport(Report report) {
        reportRepository.save(report);
    }

    @Override
    public void deleteReport(int id) {
        reportRepository.deleteById(id);
    }

    @Override
    public void updateReport(Report report) {
        reportRepository.save(report);
    }

    @Override
    public Report getReportById(int id) {
        return reportRepository.findById(id).get();
    }

    @Override
    public Report changeReportStatus(int id, String status) {
        Report report =  reportRepository.findById(id).orElse(null);
        if(null != report) {
            report.setStatus(status);
            return reportRepository.save(report);
        }
        return null;
    }
}
