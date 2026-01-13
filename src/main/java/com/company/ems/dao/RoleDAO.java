package com.company.ems.dao;

import com.company.ems.model.Role;
import java.util.List;

public interface RoleDAO {

    // Create new role
    boolean addRole(String roleName);

    // Get role by ID
    Role getRoleById(int id);

    // Get all roles
    List<Role> getAllRoles();

    // Update existing role
    boolean updateRole(Role role);

    // Delete role by ID
    boolean deleteRole(int id);
}
