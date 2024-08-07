package com.example.demo.Services.Interfaces;

import com.example.demo.Entites.Report;

import java.util.List;

public interface ReportServiceI {
    public List<Report> getOwnerReports(int id);
    public List<Report> getUserReports(int id);
    public List<Report> getAllReports();
    public void insertReport(Report report);
    public void deleteReport(int id);
    public void updateReport(Report report);
    public Report getReportById(int id);
    public Report changeReportStatus(int id , String status);
}
