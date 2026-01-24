📔 Digital Diary Application

Digital Diary is a full-stack web application built using Spring Boot that allows users to create, manage, and view personal diary entries.
The project follows a clean layered architecture and exposes RESTful APIs, which are consumed by a lightweight frontend built using HTML and JavaScript.

This application is mainly designed for learning and practicing Spring Boot, REST APIs, JPA, and frontend–backend integration in a real-world manner.

🚀 Project Overview

The Digital Diary application provides functionality to:

Register and manage users

Create diary entries linked to users

View diaries user-wise and individually

Delete diary entries

Fetch data through REST APIs

Display real-time diary data on frontend pages

The focus of this project is backend correctness, API design, and data flow, rather than heavy UI styling.

🛠 Technology Stack
Backend

Java

Spring Boot

Spring Data JPA

Hibernate

MySQL

Frontend

HTML

JavaScript

Fetch API

(UI styling is intentionally minimal to focus on logic and integration)

Tools & Utilities

Maven

Git & GitHub

Postman

Live Server (VS Code)

📁 Project Structure
com.demo
├── controller
│   ├── AuthController.java
│   └── DiaryController.java
│
├── service
│   ├── UserService.java
│   ├── DiaryService.java
│   └── impl
│       ├── UserServiceImpl.java
│       └── DiaryServiceImpl.java
│
├── dao
│   ├── UserDao.java
│   └── DiaryDao.java
│
├── model
│   ├── User.java
│   └── Diary.java
│
└── DiaryAppApplication.java

🔁 Application Flow
Controller → Service → DAO → Database


Controller handles HTTP requests and responses

Service contains business logic

DAO (Repository) interacts with the database using JPA

MySQL stores user and diary data

🌐 REST API Endpoints
👤 User APIs

GET /api/auth/all
→ Fetch all users

GET /api/auth/email/{email}
→ Fetch user by email

GET /api/auth/id/{id}
→ Fetch user by ID

GET /api/auth/name/{name}
→ Fetch users by name

📖 Diary APIs

GET /api/diary/all
→ Fetch all diary entries

GET /api/diary/dreq/{userId}
→ Fetch all diaries of a specific user

GET /api/diary/dreq1/{id}
→ Fetch diary by diary ID

POST /api/diary/dreq2/save
→ Create and save a new diary entry

DELETE /api/diary/dreq3/{id}
→ Delete a diary entry

🖥 Frontend Integration

The frontend is implemented using plain HTML and JavaScript.

Key points:

Uses Fetch API to call backend REST endpoints

Displays user-specific diary data

Shows diary count and diary list dynamically

Communicates with backend using localhost URLs

⚠️ Important:
The frontend must be opened using Live Server (or any local server).
Opening HTML files directly may cause CORS and browser security issues.

▶️ How to Run the Project

Clone the repository

Configure MySQL database

Update application.properties

Run the Spring Boot application

Open frontend using Live Server

Test APIs using browser or Postman

🧠 Key Concepts Used

RESTful Web Services

Spring Boot Architecture

Spring Data JPA & Hibernate

Dependency Injection

Controller–Service–DAO Pattern

Entity Relationships (@ManyToOne)

Frontend–Backend Integration

Error handling and debugging in Spring Boot

🔮 Future Enhancements

User authentication & authorization

Input validation and global exception handling

Update diary entries (edit feature)

Pagination and sorting of diaries

Improved frontend UI

Spring Security & JWT integration

Cloud deployment (AWS / Render / Railway)

👨‍💻 Author

Haridas Shinde
Java & Spring Boot Developer
