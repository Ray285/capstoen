package com.wayne.edu.Services;

import com.wayne.edu.entities.User;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 11/7/13
 * Time: 5:04 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    public User getUser(String login);

}
