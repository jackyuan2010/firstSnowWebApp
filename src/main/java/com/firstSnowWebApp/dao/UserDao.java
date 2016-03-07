package com.firstSnowWebApp.dao;

import org.apache.commons.lang.StringUtils;
import org.j8ql.Record;
import org.j8ql.Runner;
import org.j8ql.query.Condition;
import org.j8ql.query.Query;

import com.google.inject.Singleton;
import org.j8ql.query.SelectQuery;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.firstSnowWebApp.entity.User;

/**
 * Created by Administrator on 2/27/2016.
 */
@Singleton
public class UserDao extends BaseDao<User,Long>{
    // --------- Get --------- //
    // TODO: needs to return Option<User>
    public User getByUsername(String username){
        return daoHelper.first(Query.select(entityClass).where("username", username)).orElse(null);
    }

    public User getById(Long id){
        return daoHelper.first(Query.select(entityClass).where("id",id)).orElse(null);
    }
    // --------- /Get --------- //

    // --------- Create --------- //
    /**
     * Higher level methods to create a user.
     * @param username
     * @param password
     * @return
     */
    public User createUser(String username, String password){
        User user = new User(username, password);
        //user.setCtime(LocalDateTime.now());
        //user.setUtime(LocalDateTime.now());
        // for User, we can create new ones without an existing User
        Long id = super.create(null, user);
        return super.get(null,id).get();
    }
    // --------- /Create --------- //
}
