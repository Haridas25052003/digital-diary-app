package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.DiaryDao;
import com.demo.model.Diary;
import com.demo.service.DiaryService;

@RestController
public class DiaryController {

	@Autowired
	private DiaryService ds;
	
	@GetMapping(value="/dreq1")
	public List<Diary> m1(){
		return ds.findAll();
	}
	
	@GetMapping(value="/dreq2/{userId}")
	public List<Diary> m2(@PathVariable int userId){
		return ds.findByUserId(userId);
	}
	
	@GetMapping(value="/dreq3/{id}")
	public List<Diary> m3(@PathVariable int id){
		return ds.findById(id);
	}
	
	
}
