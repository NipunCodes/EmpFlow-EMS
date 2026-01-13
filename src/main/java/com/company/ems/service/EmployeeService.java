package com.company.ems.service;

import com.company.ems.dao.EmployeeDAO;
import com.company.ems.model.Employee;
import com.company.ems.model.User;

import java.util.List;

public class EmployeeService {

    private final EmployeeDAO employeeDao;
    private final AuthService authService;

    public EmployeeService(EmployeeDAO employeeDao, AuthService authService){
        this.employeeDao = employeeDao;
        this.authService = authService;
    }

    public boolean addEmployee(Employee employee){
        if (employee == null){
            return false;
        }

        if (employee.getSalary() <= 0){
            return false;
        }

        employeeDao.addEmployee(employee);
        return true;
    }

    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }

    public boolean updateEmployee(Employee employee){
        if (employee == null || employee.getId() <= 0){
            return false;
        }

        if (employee.getSalary() <= 0){
            return false;
        }

        Employee existing = employeeDao.getEmployeeById(employee.getId());
        if (existing == null){
            return false;
        }

        employeeDao.updateEmployee(employee);
        return true;
    }

    public boolean deleteEmployee(int employeeId, User currentUser){

        if (!authService.isAdmin(currentUser)){
            return false;
        }

        Employee employee = employeeDao.getEmployeeById(employeeId);
        if (employee == null){
            return false;
        }

        employeeDao.deleteEmployee(employeeId);
        return true;
    }
}
