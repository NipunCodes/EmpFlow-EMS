# EmpFlow – Employee Management System (EMS)

EmpFlow is a **Java-based Employee Management System** built using **JDBC, DAO pattern, and Service layer architecture**.  
The project focuses on clean separation of concerns, maintainability, and real-world backend design practices.

This system supports **user authentication, role management, and employee operations**.

---

## 📌 Key Features

- User authentication (Login)
- Role management
- Employee CRUD operations
- DAO + DAOImpl pattern
- Service layer for business logic
- JDBC-based database interaction
- Maven project structure
- Easily extendable for future features

---

## 🏗 Architecture Overview

EmpFlow follows a **layered architecture**:

```
Main
↓
Controller
↓
Service
↓
DAO
↓
Database

```

### Why this architecture?

- Easy maintenance  
- Clear responsibility separation  
- Industry-standard backend design  
- Easy to add new features  

---

## 📁 Project Structure

```
EmpFlow-EMS/
│
├── src/
│  └── main/
│  └── java/
│  └── com/company/ems/
|  |
|  ├── controller/
|  |  ├── AuthService.java
│  |  └── EmployeeService.java
│  ├── dao/
│  │  ├── EmployeeDAO.java
│  │  ├── RoleDAO.java
│  │  ├── UserDAO.java
│  │  ├── EmployeeDAOImpl.java
│  │  ├── RoleDAOImpl.java
│  │  └── UserDAOImpl.java
│  │
│  ├── model/
│  │  ├── Employee.java
│  │  ├── Role.java
│  │  └── User.java
│  │
│  ├── service/
│  |  ├── AuthService.java
│  |  └── EmployeeService.java
│  |
|  └── resources
|     ├── db.properies
|     └── schema.sql
|
|
├── pom.xml
├── .gitignore
└── README.md
```


---

## 🧩 Package Explanation

### `model`
Contains entity classes:
- `Employee` – Employee details
- `User` – Login credentials
- `Role` – User roles

---

### `dao`
Defines database operation contracts:
- `EmployeeDAO`
- `UserDAO`
- `RoleDAO`

---

### `dao.impl`
Contains JDBC implementations:
- `EmployeeDAOImpl`
- `UserDAOImpl`
- `RoleDAOImpl`

---

### `service`
Contains business logic:
- `AuthService`
- `EmployeeService`

---

### `util`
- `DBConnection` – Manages database connection logic

---

## 🛠 Technologies Used

- Java (JDK 8+)
- JDBC
- Maven
- PostgreSQL / MySQL
- SLF4J (Logging)
- IntelliJ IDEA

---

## 🗄 Database Tables

### `users`

| Column   | Type     |
|---------|----------|
| id      | INT      |
| username| VARCHAR  |
| password| VARCHAR  |
| role_id | INT      |

---

### `roles`

| Column | Type    |
|--------|---------|
| id     | INT     |
| name   | VARCHAR |

---

### `employees`

| Column     | Type    |
|------------|---------|
| id         | INT     |
| name       | VARCHAR |
| email      | VARCHAR |
| department | VARCHAR |
| salary     | DOUBLE  |

---

## ⚙️ How to Run the Project

### 1️⃣ Clone Repository

```bash
git clone https://github.com/LahiruCodez/EmpFlow-EMS.git
cd EmpFlow-EMS
```

### 2️⃣ Configure Database

Update database credentials in db.properties:
```bash
String url = "jdbc:postgresql://localhost:5432/empflow-ems";
String username = "postgres";
String password = "your_password";
```

### 3️⃣ Build Project
```bash
mvn clean install
```

### 4️⃣ Run Application

    Run the Main class from IntelliJ IDEA.


### 🔐 Roles & Access

- ADMIN – Full access
- MANAGER – Employee management
- USER – Limited access


### 🚀 Future Improvements

- Spring Boot migration
- REST APIs
- JWT authentication
- React frontend
- Connection pooling (HikariCP)
- Unit testing with JUnit


---


