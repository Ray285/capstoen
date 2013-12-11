package com.wayne.edu.DAO;

import com.wayne.edu.entities.Release;
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
public class ReleaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
     * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
     */

    public Release findById(int id){//find Release with the specified Id
        return (Release) this.sessionFactory.getCurrentSession().createQuery("from Release s where s.id=?").setParameter(0, id).uniqueResult();
    }

    public List<Release> findAll() {//return all Releases in Release table form the database
        List releases = sessionFactory.getCurrentSession().createQuery("from Release").list();
        return releases;
    }


    public void persistOrMerge(Release release) {//save a Release
        this.sessionFactory.getCurrentSession().save(release);
    }

    public void Delete(int id){//delete Release
        Release release = (Release) this.sessionFactory.getCurrentSession().createQuery("from Release s where s.id=?").setParameter(0, id).uniqueResult();
        this.sessionFactory.getCurrentSession().delete(release);
    }

    public void edit(Release release) {


        // Retrieve existing Release via id
        Release existingRelease = (Release) this.sessionFactory.getCurrentSession().get(Release.class, release.getId());

        // Assign updated values to this Release
        existingRelease.setName(release.getName());


        // Save updates
        this.sessionFactory.getCurrentSession().save(existingRelease);
    }

}
