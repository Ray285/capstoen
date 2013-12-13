package com.wayne.edu.Services.Implementation;


import com.wayne.edu.DAO.ReportDAO;
import com.wayne.edu.Services.ReportService;
import com.wayne.edu.entities.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService{

    @Autowired
    private ReportDAO reportDAO;

    public void createReport(Report report){
        this.reportDAO.persistOrMerge(report);
    }
    public Report retrieveReport(int id){
        return this.reportDAO.findById(id);
    }
    public List<Report> retrieveAllReports(){
        return this.reportDAO.findAll();
    }
    public List<Report> retrieveAllReportsforRelease(int ReleaseId){
        return this.reportDAO.findAllWithReleaseId(ReleaseId);
    }
    public void deleteReport(int id){
        this.reportDAO.Delete(id);
    }
    public void updateReport(Report report){
        this.reportDAO.edit(report);
    }





}