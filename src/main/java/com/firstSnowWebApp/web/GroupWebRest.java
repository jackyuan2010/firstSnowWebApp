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
import com.firstSnowWebApp.dao.GroupDao;
import com.firstSnowWebApp.service.GroupService;
import com.firstSnowWebApp.web.annotation.*;
import com.firstSnowWebApp.perf.annotation.ToMonitor;

@Singleton
@ToMonitor
public class GroupWebRest{

    @Inject
    private GroupDao groupDao;

    @Inject
    private WebResponseBuilder webResponseBuilder;

    @Inject
    private GroupService groupService;

    @WebPost("/group/createGroup")
    public WebResponse createGroup(@WebUser User user, @JsonParam("props") Map props){
        return webResponseBuilder.success(groupService.createGroup(user, props));
    }

    @WebGet("/group/getGroups")
    public WebResponse getGroups(@WebUser User user){
        return webResponseBuilder.success(groupService.getGroups(user));
    }
}