package com.firstSnowWebApp.access;

import org.jomni.JomniBuilder;
import org.jomni.JomniMapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.firstSnowWebApp.dao.UserDao;
import com.firstSnowWebApp.entity.User;

/**
 * Created by Administrator on 2/27/2016.
 */
@Singleton
public class AccessManager {
    @Inject
    UserDao userDao;

    JomniMapper jomni = new JomniBuilder().build();


    /**
     * This initialize and set the UserAccessContext to this user for future use.
     *
     * Usually called from the AppAuth, but can be called in unit testing as well.
     *
     * @param user
     */
    public void initUserAccessContext(User user){
        // create and set the UserAccessContext
        UserAccessContext uac = new UserAccessContext(user.getId());

        // set set this UserAccessContext in this User object for this request session.
        // Obviously, this should not be saved in the DB, and just a way to keep the request user context accross this request session (not httpsession)
        user.setUserAccessContext(uac);
    }
}
