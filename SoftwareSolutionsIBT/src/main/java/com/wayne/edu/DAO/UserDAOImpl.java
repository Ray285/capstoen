package com.wayne.edu.DAO;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 11/7/13
 * Time: 4:33 AM
 * To change this template use File | Settings | File Templates.
 */

import com.wayne.edu.entities.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
public class UserDAOImpl implements userDAO {


    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public User getUser(String login) {
        List<User> userList = new ArrayList<User>();
        Query query = openSession().createQuery("from User u where u.login = :login");
        query.setParameter("login", login);
        userList = query.list();
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;
    }

    public void persistOrMerge(User user) {//save or update a system
        this.sessionFactory.getCurrentSession().save(user);
    }

}
