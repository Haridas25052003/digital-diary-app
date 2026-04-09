package com.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private LocalDateTime createdAt;
	
	//one user can have many diaries
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Diary> diaries=new ArrayList<>();
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", createdAt=" + createdAt + "]";
	}

	public List<Diary> getDiaries() {
		return diaries;
	}

	public void setDiaries(List<Diary> diaries) {
		this.diaries = diaries;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}

/*

Act as a senior Spring Boot architect and full-stack developer with 20+ years of experience.

I have built a backend project called "Digital Diary" using Spring Boot with the following features:

* REST APIs for User and Diary management
* Layered architecture (Controller, Service, DAO, Model)
* JPA relationships (One-to-Many between User and Diary)
* CRUD operations for diary entries

Now I want to OPTIMIZE and UPGRADE this project into a FULL-STACK application.

Your tasks:

1. Analyze and improve backend:

   * Add proper exception handling (GlobalExceptionHandler)
   * Add validation annotations (@Valid, @Email, etc.)
   * Replace field injection with constructor injection
   * Avoid returning null (use Optional properly)
   * Add update APIs (PUT/PATCH)
   * Suggest DTO pattern if needed

2. Frontend Integration (IMPORTANT):

   * Create multiple frontend pages using HTML, CSS, JS (no React)
   * Pages required:

     * Login Page
     * Register Page
     * Dashboard Page
     * Create Diary Page
     * View Diaries Page
     * Edit Diary Page
   * Connect frontend with backend APIs using fetch()

3. Static Folder Structure:

   * Organize CSS, JS, and images properly
   * Follow best practices for Spring Boot static resources

4. UI/UX:

   * Modern, clean, responsive UI
   * Use simple animations and good layout

5. Security (Basic):

   * Add simple login validation (no JWT needed initially)
   * Prevent duplicate email registration

6. Performance & Code Quality:

   * Optimize code readability
   * Follow industry best practices

7. Output Required:

   * Updated backend code (only improved parts)
   * Complete frontend HTML, CSS, JS files
   * Proper folder structure
   * Step-by-step explanation

Make the project PROFESSIONAL and INTERVIEW-READY.

 */
