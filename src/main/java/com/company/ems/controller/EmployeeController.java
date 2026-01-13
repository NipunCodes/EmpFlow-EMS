package com.company.ems.controller;

import com.company.ems.service.EmployeeService;
import com.company.ems.model.Employee;
import com.company.ems.model.User;

import java.util.List;

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Add new employee
    public boolean addEmployee(Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // Returns all employees
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Update employee details
    public boolean updateEmployee(Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    // Delete an employee (Admin only)
    public boolean deleteEmployee(int employeeId, User currentUser) {
        return employeeService.deleteEmployee(employeeId, currentUser);
    }
}
