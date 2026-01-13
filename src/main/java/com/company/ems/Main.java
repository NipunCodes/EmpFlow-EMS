package com.company.ems;

import com.company.ems.controller.AuthController;
import com.company.ems.controller.EmployeeController;
import com.company.ems.dao.EmployeeDAO;
import com.company.ems.dao.UserDAO;
import com.company.ems.dao.EmployeeDAOImpl;
import com.company.ems.dao.UserDAOImpl;
import com.company.ems.model.Employee;
import com.company.ems.model.User;
import com.company.ems.service.AuthService;
import com.company.ems.service.EmployeeService;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Wiring dependencies
        UserDAO userDAO = new UserDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        AuthService authService = new AuthService(userDAO);
        EmployeeService employeeService = new EmployeeService(employeeDAO, authService);

        AuthController authController = new AuthController(authService);
        EmployeeController employeeController = new EmployeeController(employeeService);

        System.out.println("Welcome to EmpFlow EMS");


        // Login loop
        User currentUser = null;

        while (currentUser == null) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            currentUser = authController.login(username, password);
            if (currentUser == null) {
                System.out.println("Invalid credentials. Please try again.");
            }
        }

        System.out.println("Login successful! Welcome, " + currentUser.getUsername());

        boolean isAdmin = authService.isAdmin(currentUser);


        // Role-based menu
        if (isAdmin) {
            adminMenu(scanner, employeeController, currentUser);
        } else {
            hrMenu(scanner, employeeController);
        }

        scanner.close();
        System.out.println("Thank you for using EmpFlow EMS!");
    }

    // Admin menu
    private static void adminMenu(Scanner scanner, EmployeeController employeeController, User currentUser) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("0. Register User");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Logout");
            System.out.println("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 0 -> {
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Enter role ID (1 for Admin, 2 for HR): ");
                    int roleId = Integer.parseInt(scanner.nextLine());

                    AuthController authController = new AuthController(new AuthService(new UserDAOImpl()));
                    User newUser = authController.register(newUsername, newPassword, roleId);
                    if (newUser != null) {
                        System.out.println("User " + newUser.getUsername() + " registered successfully.");
                    } else {
                        System.out.println("Failed to register user.");
                    }
                }
                case 1 -> {
                    Employee emp = readEmployee(scanner, false);
                    boolean success = employeeController.addEmployee(emp);
                    System.out.println(success ? "Employee added successfully." : "Failed to add employee.");
                }
                case 2 -> {
                    List<Employee> employees = employeeController.getAllEmployees();
                    employees.forEach(System.out::println);
                }
                case 3 -> {
                    Employee emp = readEmployee(scanner, true);
                    boolean success = employeeController.updateEmployee(emp);
                    System.out.println(success ? "Employee updated successfully." : "Failed to update employee.");
                }
                case 4 -> {
                    System.out.print("Enter Employee ID to delete: ");
                    int empId = Integer.parseInt(scanner.nextLine());
                    boolean success = employeeController.deleteEmployee(empId, currentUser);
                    System.out.println(success ? "Employee deleted successfully." : "Failed to delete employee.");
                }
                case 5 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    // HR menu
    private static void hrMenu(Scanner scanner, EmployeeController employeeController) {
        while (true) {
            System.out.println("\nHR Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Logout");

            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    Employee emp = readEmployee(scanner, false);
                    boolean success = employeeController.addEmployee(emp);
                    System.out.println(success ? "Employee added successfully." : "Failed to add employee.");
                }
                case 2 -> {
                    List<Employee> employees = employeeController.getAllEmployees();
                    employees.forEach(System.out::println);
                }
                case 3 -> {
                    Employee emp = readEmployee(scanner, true);
                    boolean success = employeeController.updateEmployee(emp);
                    System.out.println(success ? "Employee updated successfully." : "Failed to update employee.");
                }
                case 4 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }


    // Helper method
    private static Employee readEmployee(Scanner scanner, boolean isUpdate) {

        int id = 0;
        if (isUpdate) {
            System.out.print("Employee ID: ");
            id = Integer.parseInt(scanner.nextLine());
        }

        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Department: ");
        String department = scanner.nextLine();
        System.out.print("Position: ");
        String position = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = Double.parseDouble(scanner.nextLine());

        return new Employee(id, name, department, position, salary);
    }
}
