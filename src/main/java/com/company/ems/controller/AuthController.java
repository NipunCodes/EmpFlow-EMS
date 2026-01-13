package com.company.ems.controller;

import com.company.ems.service.AuthService;
import com.company.ems.model.User;

public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Method to handle user login from the UI
    public User login(String username, String password) {
        return authService.login(username, password);
    }

    public User register(String username, String password, int roleId) {
        // Registration logic can be added here
        return authService.register(username, password, roleId);
    }
}
