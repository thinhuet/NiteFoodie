package com.t3h.nitefoodie.model;

/**
 * Created by dungtx on 02/07/2017.
 */

public class User {
    private String uid;
    private String email;
    private String name;

    public User() {
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}