package com.roundforest.model;

/**
 * Created by UA C on 03.07.2017.
 */
public class User {
    private String UserId;

    public User() {
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId='" + UserId + '\'' +
                '}';
    }
}
