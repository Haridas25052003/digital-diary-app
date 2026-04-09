package com.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Name is required")
	@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Please provide a valid email")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "Password is required")
	@Size(min = 4, message = "Password must be at least 4 characters")
	private String password;

	private LocalDateTime createdAt;

	// One user → many diaries
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore  // Prevents infinite recursion in JSON serialization
	private List<Diary> diaries = new ArrayList<>();

	// ✅ Auto-set timestamp before saving
	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}

	// ─── Getters & Setters ────────────────────────────────────────────────────

	public int getId()                     { return id; }
	public void setId(int id)              { this.id = id; }

	public String getName()                { return name; }
	public void setName(String name)       { this.name = name; }

	public String getEmail()               { return email; }
	public void setEmail(String email)     { this.email = email; }

	public String getPassword()            { return password; }
	public void setPassword(String password){ this.password = password; }

	public LocalDateTime getCreatedAt()    { return createdAt; }
	public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

	public List<Diary> getDiaries()        { return diaries; }
	public void setDiaries(List<Diary> diaries) { this.diaries = diaries; }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}