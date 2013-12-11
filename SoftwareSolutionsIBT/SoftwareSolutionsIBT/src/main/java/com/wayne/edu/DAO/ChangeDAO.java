package com.wayne.edu.DAO;

import com.wayne.edu.entities.Changes;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: DaNice1
 * Date: 12/1/13
 * Time: 7:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ChangeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
     * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
     */

    public Changes findById(int id){//find changes with the specified Id
        return (Changes) this.sessionFactory.getCurrentSession().createQuery("from Changes s where s.id=?").setParameter(0, id).uniqueResult();
    }

    public List<Changes> findAll() {//return all changes in file table form the database
        List change = sessionFactory.getCurrentSession().createQuery("from Changes").list();
        return change;
    }

    public void persistOrMerge(Changes changes) {//save or update a changes
        this.sessionFactory.getCurrentSession().save(changes);
    }

    public void Delete(int id){//delete changes
        Changes change = (Changes) this.sessionFactory.getCurrentSession().createQuery("from Changes s where s.id=?").setParameter(0, id).uniqueResult();
        this.sessionFactory.getCurrentSession().delete(change);
    }

    public void edit(Changes change) {

        // Retrieve existing person via id
        Changes existingChange = (Changes) this.sessionFactory.getCurrentSession().get(Changes.class, change.getId());

        // Assign updated values to this person
        existingChange.setTargetfile(change.getTargetfile());
        existingChange.setGranularity(change.getGranularity());
        existingChange.setQualifiedname(change.getQualifiedname());


        // Save updates
        this.sessionFactory.getCurrentSession().save(existingChange);
    }
}
