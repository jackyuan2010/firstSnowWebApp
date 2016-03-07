package com.firstSnowWebApp.entity;

public abstract class UserScopeEntity<Long> extends BaseEntity<Long>{

    private Long userId;

    public Long getUserId() { return this.userId; }

    public void setUserId(Long userId) { this.userId = userId; }

}