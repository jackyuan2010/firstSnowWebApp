package com.firstSnowWebApp.service;


import com.firstSnowWebApp.dao.UserDao;
import com.firstSnowWebApp.entity.*;
import com.google.inject.Inject;
import com.google.inject.Singleton;
/**
 * Created by Administrator on 2/27/2016.
 */
public class UserService {
    @Inject
    private UserDao userDao;
    @Inject
    private PasswordService passwordService;

    /**
     * Higher level methods to create a user.
     * @param username
     * @param password
     * @return
     */
    public User createUser(String username, String password){
        return userDao.createUser(username, password);
    }
}
