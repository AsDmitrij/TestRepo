package com.epam.automation.service;

import com.epam.automation.model.User;

public class UserFactory {

    public static final String USER_NAME = "rxzh6hr71b";
    public static final String USER_PASSWORD = "C/vA_*2f=8";

    public static User createUser() {
        return new User(USER_NAME, USER_PASSWORD);
    }
}
