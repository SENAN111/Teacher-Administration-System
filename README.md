# Teacher Administration System

**A Java-Based Application for Managing Teacher Records**

<p align="center">
  <img src="https://img.shields.io/badge/Java-24-orange?style=for-the-badge&logo=openjdk" />
  <img src="https://img.shields.io/badge/Architecture-Layered-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Status-In%20Development-yellow?style=for-the-badge" />
</p>

## Overview

Teacher Administration System is a console-based application developed using Java to manage teacher records efficiently.

The project demonstrates practical implementation of Object-Oriented Programming (OOP) principles, layered architecture, data validation, and business logic separation.

It provides functionality for registering, retrieving, searching, and updating teacher information while maintaining data consistency through validation and duplicate-checking mechanisms.

## Key Features

- **Teacher Registration:** Add new teacher records with validated information.
- **Teacher Retrieval:** Access and display stored teacher information.
- **Search by ID:** Find teachers using their unique identification number.
- **Search by FIN:** Retrieve teacher records using their FIN code.
- **Update Teacher Information:** Modify existing teacher details.
- **Input Validation:** Validate user-provided data before processing.
- **Duplicate Prevention:** Prevent duplicate FIN codes and email addresses.
- **Centralized Input Management:** Handle console input through a shared Scanner utility.

## Technology Stack

| Technology | Description |
|---|---|
| Java 24 | Core programming language |
| OOP | Object-oriented programming principles |
| ArrayList | In-memory data storage |
| Java Collections Framework | Collection management |
| Regular Expressions (Regex) | Input validation |
| IntelliJ IDEA | Development environment |
| Git & GitHub | Version control and source code hosting |

## Project Architecture

The application is organized into separate packages following a layered architecture approach.

```text
src/
│
├── models/
│   └── Teacher.java
│
├── repository/
│   └── TeacherRepository.java
│
├── service/
│   └── TeacherService.java
│
└── utill/
    ├── AppScanner.java
    └── ValidationUtil.java
```

### Architecture Components

**Models Layer**
- Defines the Teacher entity.
- Encapsulates teacher attributes.
- Manages object initialization and data access.

**Repository Layer**
- Manages teacher records using ArrayList.
- Provides data retrieval and search operations.
- Checks the existence of FIN codes and email addresses.

**Service Layer**
- Contains application business logic.
- Coordinates operations between the repository and user input.
- Handles teacher registration and update processes.

**Utility Layer**
- `ValidationUtil`: Provides reusable validation methods.
- `AppScanner`: Centralizes console input management.

## Data Validation

The application implements validation rules to maintain data accuracy and consistency.

| Field | Validation |
|---|---|
| Name | 3–20 alphabetic characters |
| Age | Between 18 and 70 |
| FIN | Exactly 7 alphanumeric characters |
| Email | Valid email format |
| Phone Number | Azerbaijani mobile number format |
| Salary | Must be greater than zero |

### Data Integrity

- FIN codes must be unique.
- Email addresses must be unique.
- User input is validated before processing.
- Existing teacher records are checked during update operations.

## Installation & Execution

### Prerequisites

- JDK 24 or compatible Java Development Kit
- IntelliJ IDEA
- Git

### Clone Repository

```bash
git clone https://github.com/SENAN111/Teacher-Administration-System.git
```

### Run the Application

1. Open the project in IntelliJ IDEA.
2. Configure the JDK.
3. Locate the main application class.
4. Run the application.

## Technical Concepts Applied

This project demonstrates practical knowledge of:

- Object-Oriented Programming (OOP)
- Encapsulation
- Constructors and object initialization
- Static members
- Layered application architecture
- Constructor-based Dependency Injection
- Java Collections Framework
- ArrayList and iteration
- Regular Expressions
- Method design and code reusability
- Separation of concerns
- Input validation and data integrity

## Future Enhancements

The following improvements are planned for future versions:

- Delete teacher functionality
- Database integration using JDBC and MySQL
- Persistent data storage
- Exception handling and custom exceptions
- Unit testing with JUnit
- REST API development using Spring Boot

## Author

**Sənan Behbudov**

Aspiring Java Backend Developer

**Technologies & Interests:** Java | Spring Boot | SQL | Backend Development

GitHub: [SENAN111](https://github.com/SENAN111)

---

*Developed as a practical Java project to strengthen programming skills and gain hands-on experience in backend development.*
