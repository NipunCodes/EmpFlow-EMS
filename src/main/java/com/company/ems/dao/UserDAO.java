package com.company.ems.dao;

import com.company.ems.model.User;
import java.util.List;

public interface UserDAO {

    // Create new user
    boolean addUser(User user);

    // Get user by ID
    User getUserById(int id);

    // Get all users
    List<User> getAllUsers();

    // Update existing user
    boolean updateUser(User user);

    // Delete user by ID
    boolean deleteUser(int id);

    // Login user
    User findByUsernameAndPassword(String username, String password);

    //register user
    User findByUsername(String username);
}
