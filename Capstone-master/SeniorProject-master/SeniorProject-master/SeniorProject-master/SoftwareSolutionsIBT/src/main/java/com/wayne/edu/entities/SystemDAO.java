package com.wayne.edu.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired private SessionFactory sessionFactory;

    /**
     * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
     * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
     */

    @Transactional
    public List<System> findAllSystems() {
        Session session = sessionFactory.openSession();

        List<System> systems = session.createQuery("select p from System as p").list();

        return systems;
    }

    @Transactional
    public List<System> findAllSystemswithReleases() {
        Session session = sessionFactory.openSession();

        List<System> systems = session.createQuery("select distinct p from System as p left join fetch p.releases").list();

        return systems;
    }




}
