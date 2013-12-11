package com.wayne.edu.DAO;

import com.wayne.edu.entities.Revision;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class RevisionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Revision findById(int id){
        return (Revision) this.sessionFactory.getCurrentSession().createQuery("from Revision s where s.id=?").setParameter(0, id).uniqueResult();
    }

    public List<Revision> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Revision").list();
    }

    public List<Revision> findAllWithRevisions() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select s from Revision s left join fetch s.system").list();
    }

    public void persistOrMerge(Revision revision) {
        this.sessionFactory.getCurrentSession().save(revision);
    }

    public void Delete(int id) {
        Revision revision = (Revision) this.sessionFactory.getCurrentSession().createQuery("from System s where s.id=?").setParameter(0, id).uniqueResult();
        this.sessionFactory.getCurrentSession().delete(revision);
    }

    public void edit(Revision revision) {

        Revision existingRevision = (Revision) this.sessionFactory.getCurrentSession().get(Revision.class,revision.getId());
        // Assign updated values to this revision

        existingRevision.setName(revision.getName());
        existingRevision.setvcsid(revision.getvcsid());
        existingRevision.setComment(revision.getComment());
        // Save updates
        this.sessionFactory.getCurrentSession().save(existingRevision);
    }

}

