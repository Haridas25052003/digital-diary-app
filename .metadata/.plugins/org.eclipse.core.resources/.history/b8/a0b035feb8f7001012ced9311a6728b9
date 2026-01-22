package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.UserService;
import com.demo.model.*;

@RestController
public class AuthController {
	
	@Autowired
	private UserService us;
	
	@GetMapping(value="/")
	public List<User> m1(){
		return us.findAll();
	}
	
	@GetMapping(value="/req1/{email}")
	public List<User> m2(@PathVariable String email){
		return us.findByEmail(email);
	}

	@GetMapping(value="req2/{id}")
	public List<User> m3(@PathVariable int id){
		return us.findById(id);
	}
	
	@GetMapping(value="req3/{name}")
	public List<User> m4(@PathVariable String name){
		return us.findByName(name);
	}
}
