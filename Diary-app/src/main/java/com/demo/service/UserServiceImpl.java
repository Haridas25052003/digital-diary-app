package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.model.User;

@Service //for showing the business logic 
public class UserServiceImpl implements UserService{

	@Autowired //used for automatic dependency injection
	private UserDao ud;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return ud.findAll();
	}

}
