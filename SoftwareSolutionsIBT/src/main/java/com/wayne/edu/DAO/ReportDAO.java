package com.wayne.edu.DAO;

import com.wayne.edu.entities.Report;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class ReportDAO{

    @Autowired
    private SessionFactory sessionFactory;


    public void persistOrMerge(Report report) {
        this.sessionFactory.getCurrentSession().save(report);
    }

    public Report findById(Integer id) {
        return (Report) this.sessionFactory.getCurrentSession().createQuery("from Report s where s.id=?").setParameter(0, id).uniqueResult();
    }

    public List<Report> findAll() { Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Report").list();
    }

    public List<Report> findAllWithReleaseId(int releaseid) { Session session = sessionFactory.getCurrentSession();
        List reports = sessionFactory.getCurrentSession().createQuery("from Report s where s.release.id=?").setParameter(0, releaseid).list();
        return reports;
    }

    public void Delete(int id) {  Report report = (Report) this.sessionFactory.getCurrentSession().createQuery("from Report s where s.id=?").setParameter(0, id).uniqueResult();
        this.sessionFactory.getCurrentSession().delete(report);
    }

    public void edit(Report report) {
        Report existingReport = (Report) this.sessionFactory.getCurrentSession().get(Report.class, report.getId());

        existingReport.setRelease(report.getRelease());
        existingReport.setId(report.getId());
        existingReport.setTitle(report.getTitle());
        existingReport.setDescription(report.getDescription());
        existingReport.setType(report.getType());

        this.sessionFactory.getCurrentSession().save(existingReport);
    }
}
