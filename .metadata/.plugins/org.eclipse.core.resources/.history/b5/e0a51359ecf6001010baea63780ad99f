package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.User;

public interface UserDao extends JpaRepository<User,Integer>{

	//User saveUser(User user);
	
	List<User> findAll();
	
	List<User> findByEmail(String email);
	
	List<User> findById(int id);
	
	List<User> findByName(String name);

	User saveUser(User user);
	
	boolean exitsByEmail(String email);
	
}
