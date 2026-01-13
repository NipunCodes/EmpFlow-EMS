package com.company.ems.dao;

import com.company.ems.model.Employee;
import java.util.List;

public interface EmployeeDAO {

    // Create new employee
    boolean addEmployee(Employee employee);

    // Get employee by ID
    Employee getEmployeeById(int id);

    // Get all employees
    List<Employee> getAllEmployees();

    // Update existing employee
    boolean updateEmployee(Employee employee);

    // Delete employee by ID
    boolean deleteEmployee(int id);
}
