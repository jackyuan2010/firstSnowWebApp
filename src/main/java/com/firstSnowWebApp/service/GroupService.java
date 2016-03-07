package com.firstSnowWebApp.service;

import com.firstSnowWebApp.dao.GroupDao;
import com.firstSnowWebApp.entity.*;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.*;
import java.util.stream.Collectors;

@Singleton
public class GroupService {
    @Inject
    private GroupDao groupDao;

    /**
     * @param user
     * @param map
     * @return
     */
    public Long createGroup(User user, Map map){
        if(map.get("groupName") == null){
            return new Long(-1);
        }
        return groupDao.createGroup(user, map.get("groupName").toString());
    }

    public List<Group> getGroups(User user){
        return groupDao.getGroups(user);
    }
}
