📔 Digital Diary Application

Digital Diary is a backend application built using Spring Boot that allows users to securely manage their personal diary entries. The application follows a layered architecture and provides RESTful APIs for user and diary management.

🚀 Features (Current)

User registration and login

Create, view, and delete diary entries

One-to-Many relationship between User and Diary

Secure database mapping using JPA & Hibernate

Clean layered architecture (Controller, Service, DAO, Repository)

🛠️ Technology Stack

Java 17

Spring Boot

Spring Data JPA

Hibernate

MySQL

Maven

REST APIs

🧱 Project Architecture
Controller → Service → DAO → Repository → Database

📁 Project Structure
src/main/java
 └── com.demo.diaryapp
     ├── controller
     ├── service
     ├── dao
     ├── repository
     ├── entity
     └── dto

🗄️ Database Design
User

id

name

email

password

active

createdAt

Diary

id

title

content

category

entryDate

createdAt

updatedAt

user (Foreign Key)

🔗 API Endpoints (Initial)
Authentication
POST /api/auth/register
POST /api/auth/login

Diary
POST   /api/diaries/user/{userId}
GET    /api/diaries/user/{userId}
GET    /api/diaries/{diaryId}
DELETE /api/diaries/{diaryId}

⚙️ Configuration

Database configuration is managed in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/d12
spring.datasource.username=root
spring.datasource.password=*****
spring.jpa.hibernate.ddl-auto=update

▶️ How to Run the Project

Clone the repository

Configure MySQL database

Update application.properties

Run the Spring Boot application

Test APIs using Postman

📌 Future Enhancements

Spring Security with JWT authentication

Password encryption

Role-based access

Update diary entries

Pagination and search

Deployment to cloud

👨‍💻 Author

Haridas Shinde
Aspiring Java & Backend Developer

📄 License

This project is for learning and educational purposes.
