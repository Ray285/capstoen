package com.wayne.edu.DAO;

import com.wayne.edu.entities.System;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: RaymondII
 * Date: 11/13/13
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class SystemDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
     * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
     */

    public System findById(int id){//find system with the specified Id
        return (System) this.sessionFactory.getCurrentSession().createQuery("from System s where s.id=?").setParameter(0, id).uniqueResult();
    }

    public List<System> findAll() {//return all systems in system table form the database
        List systems = sessionFactory.getCurrentSession().createQuery("from System").list();
        return systems;
    }

//    public List<System> findAllWithReleases() {//return all systems and corresponding releases in system table form the database
//        List systems = sessionFactory.getCurrentSession().createQuery("select s from System s left join fetch s.releases").list();
//        return systems;
//    }

    public void persistOrMerge(System system) {//save or update a system
        this.sessionFactory.getCurrentSession().save(system);
    }

    public void Delete(int id){//delete system
        System system = (System) this.sessionFactory.getCurrentSession().createQuery("from System s where s.id=?").setParameter(0, id).uniqueResult();
        this.sessionFactory.getCurrentSession().delete(system);
    }

    public void edit(System system) {


        // Retrieve existing system via id
        System existingSystem = (System) this.sessionFactory.getCurrentSession().get(System.class, system.getId());

        // Assign updated values to this system
        existingSystem.setName(system.getName());
        existingSystem.setProgrammingLang(system.getProgrammingLang());
        existingSystem.setIssueTrackerUrl(system.getIssueTrackerUrl());
        existingSystem.setversionControlUrl(system.getversionControlUrl());

        // Save updates
        this.sessionFactory.getCurrentSession().save(existingSystem);
    }

}
