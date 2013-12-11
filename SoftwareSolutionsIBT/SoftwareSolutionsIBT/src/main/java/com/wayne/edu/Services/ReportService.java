package com.wayne.edu.Services;

import com.wayne.edu.entities.Report;

import java.util.List;


public interface ReportService{

    public void createReport(Report report);
    public Report retrieveReport(int id);
    public List<Report> retrieveAllReports();
    public void deleteReport(int id);
    public void updateReport(Report report);

}