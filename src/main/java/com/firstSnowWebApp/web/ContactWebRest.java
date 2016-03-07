package com.firstSnowWebApp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.britesnow.snow.web.param.annotation.WebParam;
import com.britesnow.snow.web.param.annotation.WebUser;
import com.britesnow.snow.web.rest.annotation.WebGet;
import com.britesnow.snow.web.rest.annotation.WebPost;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import com.firstSnowWebApp.entity.*;
import com.firstSnowWebApp.dao.ContactDao;
import com.firstSnowWebApp.service.ContactService;
import com.firstSnowWebApp.web.annotation.*;
import com.firstSnowWebApp.perf.annotation.ToMonitor;

@Singleton
@ToMonitor
public class ContactWebRest{

    @Inject
    private ContactDao contactDao;

    @Inject
    private WebResponseBuilder webResponseBuilder;

    @Inject
    private ContactService contactService;

    @WebPost("/contact/createContact")
    public WebResponse createContact(@JsonParam("props") Map map){
        return webResponseBuilder.success(contactService.createContact(map));
    }

    @WebGet("/contact/getContactsByGroupId")
    public WebResponse getContacts(@WebParam("groupId") Long groupId){
        return webResponseBuilder.success(contactService.getContactsByGroupId(groupId));
    }
}