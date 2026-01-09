package com.company.ems.service;

import com.company.ems.dao.UserDao;
import com.company.ems.model.User;
import com.company.ems.model.Role;

public class AuthService {

    private final UserDao userDao;

    // Constructor injection
    public AuthService(UserDao userDao){
        this.userDao = userDao;
    }

    public User login(String username, String password){

        // Basic validation
        if (username == null || password == null){
            return null;
        }

        if (username.trim().isEmpty() || password.trim().isEmpty()){
            return null;
        }

        // Ask DAO to fetch user from database
        User user = userDao.findByUsernameAndPassword(username, password);

        // If user not found, login fails
        if (user == null){
            return null;
        }

        // Login successful
        return user;
    }

    // Helper method to check if user is admin
    public boolean isAdmin(User user){
        if (user == null || user.getRole() == null){
            return false;
        }
        return "ADMIN".equalsIgnoreCase(user.getRole().getRoleName());
    }

    //Helper method to check if user is HR
    public boolean isHR(User user){
        if (user == null || user.getRole() == null){
            return false;
        }
        return "HR".equalsIgnoreCase(user.getRole().getRoleName());
    }
}
