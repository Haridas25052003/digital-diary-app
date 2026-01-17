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

}
