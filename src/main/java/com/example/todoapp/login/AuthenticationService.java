package com.example.todoapp.login;

import org.springframework.stereotype.Service;

/**
 * @author Weixin Liu
 */

@Service
public class AuthenticationService {
    // authenticate a user
    public boolean authenticate(String username, String password) {
        return username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("dummy");
    }
}
