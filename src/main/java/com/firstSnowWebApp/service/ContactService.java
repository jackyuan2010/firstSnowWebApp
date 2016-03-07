package com.firstSnowWebApp.service;

import com.firstSnowWebApp.dao.ContactDao;
import com.firstSnowWebApp.entity.*;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.*;
import java.util.stream.Collectors;

@Singleton
public class ContactService {
    @Inject
    private ContactDao contactDao;

    /**
     * @param groupId
     * @param map
     * @return
     */
    public Long createContact(Map map){
        return contactDao.createContact(map);
    }

    public List<Contact> getContactsByGroupId(Long groupId){
        return contactDao.getContactsByGroupId(groupId);
    }
}
