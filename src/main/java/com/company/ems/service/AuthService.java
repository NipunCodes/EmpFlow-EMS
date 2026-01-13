package com.company.ems.service;

import com.company.ems.dao.UserDAO;
import com.company.ems.model.User;
import com.company.ems.model.Role;

public class AuthService {

    private final UserDAO userDao;

    // Constructor injection
    public AuthService(UserDAO userDao){
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

    public User register(String username, String password, int roleId) {
        // Basic validation
        if (username == null || password == null){
            return null;
        }

        if (username.trim().isEmpty() || password.trim().isEmpty()){
            return null;
        }

        // Check if role is valid
//        if (roleId != Role.getId() && roleId != Role.HR.getId()) {
//            return null;
//        }

        // Check if username already exists
        User existingUser = userDao.findByUsername(username);
        if (existingUser != null) {
            return null; // Username already taken
        }

        // Create new user
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole_id(roleId);

        // Save user to database
        userDao.addUser(newUser);

        return newUser;
    }

    // Helper method to check if user is admin
    public boolean isAdmin(User user){
        if (user == null){
            return false;
        }
        return user.getRole_id() == 1; // Role_id 1 is for admin
    }

    //Helper method to check if user is HR
    public boolean isHR(User user){
        if (user == null){
            return false;
        }
        return user.getRole_id() == 2; // Role_id 2 is for HR
    }
}
