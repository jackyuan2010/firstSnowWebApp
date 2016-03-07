package com.firstSnowWebApp.entity;

/**
 * Created by Administrator on 2/27/2016.
 */
public abstract class BaseEntity<I> {
    private I id;

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }
}
