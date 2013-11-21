package com.wayne.edu.entities;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 11/7/13
 * Time: 5:04 AM
 * To change this template use File | Settings | File Templates.
 */
import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private userDAO userDAO;

    public User getUser(String login) {
        return userDAO.getUser(login);
    }

}
