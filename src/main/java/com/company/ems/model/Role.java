package com.company.ems.model;

public class Role {
    private int role_id;
    private String role_name;

    // No-argument constructor
    public Role() {}

    // Constructor without role_id (for creating new roles)
    public Role(String role_name) {
        this.role_name = role_name;
    }

    // Constructor with role_id (for existing roles)
    public Role(int role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    // Getters and Setters
    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    // For easy printing of Role
    @Override
    public String toString() {
        return "Role{" +
                "role_id='" + role_id + '\'' +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
