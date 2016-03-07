package com.firstSnowWebApp.entity;

public class Group extends UserScopeEntity<Long>{
    private String groupName;
    private String groupDesc;

    public Group(){}

    public Group(String groupName, String groupDesc){
        this.groupName = groupName;
        this.groupDesc = groupDesc;
    }

    public String getGroupName() { return this.groupName; }

    public void setGroupName(String groupName) { this.groupName = groupName; }

    public  String getGroupDesc() { return this.groupDesc; }

    public  void  setGroupDesc(String groupDesc) { this.groupDesc = groupDesc; }
}