package com.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "diaries")
public class Diary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Title is required")
	@Size(max = 200, message = "Title must not exceed 200 characters")
	@Column(columnDefinition = "text")
	private String title;

	@NotBlank(message = "Content is required")
	@Column(columnDefinition = "text")
	private String content;

	@Column(columnDefinition = "text")
	private String category;

	private LocalDateTime createdAt;

	// Many diaries belong to one user
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "diaries", "password"})
	private User user;

	//  Transient field: accepts userId from frontend JSON
	@Transient
	private int userId;

	//  Auto-set timestamp before saving
	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}

	// ─── Getters & Setters ────────────────────────────────────────────────────

	public int getId()                         { return id; }
	public void setId(int id)                  { this.id = id; }

	public String getTitle()                   { return title; }
	public void setTitle(String title)         { this.title = title; }

	public String getContent()                 { return content; }
	public void setContent(String content)     { this.content = content; }

	public String getCategory()                { return category; }
	public void setCategory(String category)   { this.category = category; }

	public LocalDateTime getCreatedAt()        { return createdAt; }
	public void setCreatedAt(LocalDateTime dt) { this.createdAt = dt; }

	public User getUser()                      { return user; }
	public void setUser(User user)             { this.user = user; }

	public int getUserId()                     { return userId; }
	public void setUserId(int userId)          { this.userId = userId; }
}