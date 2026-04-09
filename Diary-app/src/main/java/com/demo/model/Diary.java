package com.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Diary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition="text")
	private String title;
	@Column(columnDefinition="text")
	private String content;
	@Column(columnDefinition="text")
	private String category;
	private LocalDateTime createdAt;
	
	//many diary entries belong to one user
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	

    @Transient
    private int userId;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}



/*
Act as a senior full-stack developer and Spring Boot architect with 20+ years of experience.

I have built a backend project called "Digital Diary" using Spring Boot with the following features:

* REST APIs for User and Diary management

* Layered architecture: Controller, Service, DAO, Model

* JPA relationships: One User → Many Diaries

* CRUD operations (Create, Read, Delete for diary)

* APIs:

   * /api/users (create, get users)

   * /api/diaries (create, get, delete, filter by user)

Now I want to convert this into a PROFESSIONAL FULL-STACK APPLICATION using:

* Backend: Spring Boot (existing)

* Frontend: HTML, CSS, JavaScript (NO React)

🔷 YOUR TASKS:

1. BACKEND OPTIMIZATION (IMPORTANT)

Improve my backend with production-level best practices:

* Replace field injection with constructor injection

* Add validation annotations:

   * @Valid, @Email, @NotNull, @Size

* Implement Global Exception Handling using @ControllerAdvice

* Do NOT return null — use proper error responses

* Add UPDATE API for diary (PUT/PATCH)

* Add API to filter diaries by category

* Ensure proper HTTP status codes (200, 201, 404, 400)

2. FRONTEND DEVELOPMENT (MULTI-PAGE)

Create a COMPLETE multi-page frontend using HTML, CSS, and JavaScript.

Pages required:

1. index.html → Landing page

2. register.html → User registration

3. login.html → Login page (basic email-based login)

4. dashboard.html → Shows user info + navigation

5. create-diary.html → Form to create diary

6. view-diaries.html → Display all diaries of logged-in user

7. edit-diary.html → Update diary

3. FRONTEND FUNCTIONALITY

* Use fetch() API to connect with backend

* Store logged-in user in localStorage

* Perform:

   * Register user

   * Login user

   * Create diary

   * View diaries

   * Delete diary

   * Update diary

4. STATIC FOLDER STRUCTURE (SPRING BOOT)

Organize frontend properly:

src/main/resources/ ├── static/ │ ├── css/ │ │ └── style.css │ ├── js/ │ │ └── app.js │ ├── images/ │ ├── templates/ │ ├── index.html │ ├── login.html │ ├── register.html │ ├── dashboard.html │ ├── create-diary.html │ ├── view-diaries.html │ ├── edit-diary.html

5. UI/UX REQUIREMENTS

* Clean, modern UI

* Responsive design (mobile-friendly)

* Use CSS (Flexbox/Grid)

* Add navigation bar

* Add buttons with hover effects

* Good spacing and readability

6. SECURITY (BASIC LEVEL)

* Prevent duplicate email registration

* Validate login using email

* Do NOT use JWT (keep it simple)

7. OUTPUT FORMAT

Provide:

1. Updated backend code (only changed parts)

2. Complete HTML files for all pagesfile:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/controller/AuthController.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/controller/DiaryController.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/dao/DiaryDao.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/dao/UserDao.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/model/Diary.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/model/User.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/service/DiaryService.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/service/DiaryServiceImpl.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/service/UserService.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/service/Usefile:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/controller/AuthController.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/controller/DiaryController.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/dao/DiaryDao.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/dao/UserDao.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/model/Diary.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/model/User.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/service/DiaryService.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/service/DiaryServiceImpl.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/service/UserService.java

file:/D:/Digital-Diary/Diary-app/src/main/java/com/demo/service/UserServiceImpl.javarServiceImpl.java

3. CSS file (style.css)

4. JavaScript file (app.js)

5. Step-by-step explanation of how everything connects

8. GOAL

Make this project:

* Interview-ready

* Clean and professional

* Easy to understand

* Real-world structured

IMPORTANT:

* Do NOT overcomplicate

* Keep code clean and readable

* Follow best practices

* Explain clearly wherever needed
 */