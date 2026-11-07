# Teacher Administration System

A Java-based console application for managing teacher records using PostgreSQL and JDBC.

## Overview

Teacher Administration System is a console-based application developed with Java. It allows users to manage teacher information through a menu-driven interface.

The application follows a layered architecture and uses PostgreSQL for persistent data storage.

## Features

- Add new teachers
- Display all teachers
- Update teacher information
- Delete teachers
- Search teachers by ID
- Search teachers by FIN
- Count registered teachers
- Sort teachers by age
- Sort teachers by salary
- Calculate average salary
- Find the highest-paid teacher
- Validate user input
- Prevent duplicate FIN codes and email addresses

## Technologies

| Technology | Purpose |
|---|---|
| Java 24 | Application development |
| PostgreSQL | Relational database |
| JDBC | Database connectivity |
| Docker | Running PostgreSQL |
| IntelliJ IDEA | Development environment |
| Git & GitHub | Version control |

## Project Architecture

The project uses a layered architecture to separate responsibilities.

```text
src/
├── Main.java
├── database/
│   └── DatabaseConnection.java
├── models/
│   └── Teacher.java
├── repository/
│   └── TeacherRepository.java
├── service/
│   └── TeacherService.java
└── utill/
    ├── AppScanner.java
    └── ValidationUtil.java
```

### Architecture Layers

- **Model:** Represents teacher data and its attributes.
- **Repository:** Handles database operations using JDBC and SQL.
- **Service:** Contains business logic and coordinates application operations.
- **Database:** Manages the PostgreSQL connection.
- **Utility:** Provides input handling and validation methods.

## Database Structure

The application uses a PostgreSQL table named `teachers`.

| Column | Data Type | Description |
|---|---|---|
| id | BIGSERIAL | Primary key |
| name | VARCHAR(100) | Teacher's first name |
| sur_name | VARCHAR(100) | Teacher's surname |
| fin | VARCHAR(7) | Unique FIN code |
| age | INTEGER | Teacher's age |
| email | VARCHAR(150) | Unique email address |
| number | VARCHAR(20) | Phone number |
| salary | NUMERIC(10,2) | Teacher's salary |

## Setup and Installation

### Requirements

- JDK 24 or compatible JDK
- PostgreSQL
- Docker
- IntelliJ IDEA
- PostgreSQL JDBC Driver

### 1. Clone the Repository

```bash
git clone https://github.com/SENAN111/Teacher-Administration-System.git
```

### 2. Configure PostgreSQL

Create a PostgreSQL database named `teacher_db` and a table:

```sql
CREATE TABLE teachers (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    sur_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    number VARCHAR(20),
    fin VARCHAR(7) UNIQUE,
    age INTEGER,
    salary NUMERIC(10,2)
);
```

### 3. Add PostgreSQL JDBC Driver

Add the PostgreSQL JDBC Driver to the project dependencies in IntelliJ IDEA.

### 4. Configure Environment Variables

Set the following environment variables in IntelliJ IDEA Run Configuration:

```text
DB_URL=jdbc:postgresql://localhost:5432/teacher_db
DB_USER=your_database_username
DB_PASSWORD=your_database_password
```

**Important:** Never commit database passwords or other sensitive credentials to GitHub.

### 5. Run the Application

Open the project in IntelliJ IDEA and run `Main.java`.

## Learning Objectives

This project demonstrates practical experience with:

- Java Object-Oriented Programming (OOP)
- Encapsulation and constructors
- Layered architecture
- Separation of concerns
- JDBC and SQL operations
- PostgreSQL database integration
- CRUD operations
- Data validation
- Exception handling
- Java Collections Framework

## Future Improvements

- Migrate the project to Maven
- Add unit tests using JUnit
- Develop REST APIs using Spring Boot
- Implement authentication and authorization

## Author

**Sənan Behbudov**

Aspiring Java Backend Developer

GitHub: [SENAN111](https://github.com/SENAN111)

Project Repository: [Teacher Administration System](https://github.com/SENAN111/Teacher-Administration-System)</Writing
