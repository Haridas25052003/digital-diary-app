Digital Diary Application

Digital Diary is a simple full-stack application built using Spring Boot that allows users to manage personal diary entries.
The project follows a layered architecture and exposes REST APIs which are consumed by a basic frontend built using HTML and JavaScript.

Project Overview

The application provides functionality to:

Manage users

Create, view, and delete diary entries

Fetch diary entries through REST APIs

Display diary data on a simple frontend page

This project is designed for learning Spring Boot, REST APIs, JPA, and frontend-backend integration.

Technology Stack

Backend:

Java

Spring Boot

Spring Data JPA

Hibernate

MySQL

//(in progress)
Frontend:

HTML

JavaScript (Fetch API)

Tools:

Maven

Git & GitHub

Postman

Project Structure
com.demo
 ├── controller
 │    ├── AuthController.java
 │    └── DiaryController.java
 ├── service
 │    ├── UserService.java
 │    ├── DiaryService.java
 │    └── impl
 │         ├── UserServiceImpl.java
 │         └── DiaryServiceImpl.java
 ├── dao
 │    ├── UserDao.java
 │    └── DiaryDao.java
 ├── model
 │    ├── User.java
 │    └── Diary.java
 └── DiaryAppApplication.java

Application Flow
Controller → Service → DAO → Database


Controller handles HTTP requests

Service contains business logic

DAO interacts with the database using JPA

MySQL stores application data

REST API Endpoints
User APIs

GET /api/auth/all – Get all users

GET /api/auth/email/{email} – Get user by email

GET /api/auth/id/{id} – Get user by id

GET /api/auth/name/{name} – Get users by name

Diary APIs

GET /api/diary/all – Get all diary entries

GET /api/diary/dreq/{userId} – Get diaries by userId

GET /api/diary/dreq1/{id} – Get diary by diaryId

POST /api/diary/dreq2/save – Save diary

DELETE /api/diary/dreq3/{id} – Delete diary

Frontend Integration

A simple frontend page (frontpage.html) is used to:

Fetch all diary entries using Fetch API

Display diary data in the browser

The frontend must be served using a local server (Live Server or similar) to avoid browser security restrictions.

How to Run the Project

Clone the repository

Configure MySQL database

Update application.properties

Run the Spring Boot application

Open frontend using Live Server

Access APIs using browser or Postman

Key Concepts Used

RESTful Web Services

Spring Boot Architecture

Spring Data JPA

Dependency Injection

Controller-Service-DAO pattern

Frontend and Backend integration

Future Enhancements

User authentication and authorization

Validation and exception handling

Update diary entries

Improved frontend UI

Security using Spring Security

Deployment to cloud

Author

Haridas Shinde
Java & Spring Boot Developer
