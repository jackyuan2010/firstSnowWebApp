package com.firstSnowWebApp.entity;

import com.firstSnowWebApp.access.UserAccessContext;

/**
 * Created by Administrator on 2/27/2016.
 */
public class User extends BaseEntity<Long>{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String photoUrl;

    //// per request properties
    private UserAccessContext userAccessContext;

    public User(){};

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (firstName != null) {
            sb.append(firstName).append(" ");
        }
        if (lastName != null) {
            sb.append(lastName);
        }
        if (firstName == null && lastName == null) {
            sb.append(username);
        }
        return sb.toString();
    }

    // --------- Persistent Properties --------- //
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }


    public UserAccessContext getUserAccessContext() {
        return userAccessContext;
    }

    public void setUserAccessContext(UserAccessContext userAccessContext) {
        this.userAccessContext = userAccessContext;
    }

    // --------- /Persistent Properties --------- //
}
