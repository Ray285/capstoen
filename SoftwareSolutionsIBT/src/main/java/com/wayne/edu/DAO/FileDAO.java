package com.wayne.edu.DAO;

import com.wayne.edu.entities.File;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: DaNice1
 * Date: 12/1/13
 * Time: 1:26 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class FileDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
     * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
     */

    public File findById(int id){//find file with the specified Id
        return (File) this.sessionFactory.getCurrentSession().createQuery("from File s where s.id=?").setParameter(0, id).uniqueResult();
    }

    public List<File> findAll() {//return all files in file table form the database
        List files = sessionFactory.getCurrentSession().createQuery("from File").list();
        return files;
    }

    public List<File> findAllByRevision(int revisionId) {//return all files in file table form the database
        List files = sessionFactory.getCurrentSession().createQuery("from File s where s.revision.id=?").setParameter(0, revisionId).list();
        return files;
    }

    public void persistOrMerge(File file) {//save or update a file
        this.sessionFactory.getCurrentSession().save(file);
    }

    public void Delete(int id){//delete file
        File file = (File) this.sessionFactory.getCurrentSession().createQuery("from File s where s.id=?").setParameter(0, id).uniqueResult();
        this.sessionFactory.getCurrentSession().delete(file);
    }

    public void edit(File file) {


        // Retrieve existing person via id
        File existingFile = (File) this.sessionFactory.getCurrentSession().get(File.class, file.getId());

        // Assign updated values to this person
        existingFile.setName(file.getName());
        existingFile.setPath(file.getPath());
        existingFile.setRevision(file.getRevision());

        // Save updates
        this.sessionFactory.getCurrentSession().save(existingFile);
    }
}
