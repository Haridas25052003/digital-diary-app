package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.DiaryDao;
import com.demo.model.Diary;

@Service
public class DiaryServiceImpl implements DiaryService{

	@Autowired
	private DiaryDao dd;
	
	@Override
	public List<Diary> findAll() {
		
		return dd.findAll();
	}

	@Override
	public List<Diary> findDiariesByUserId(int userId) {
		
		return dd.findDiariesByUserId(userId);
	}

	@Override
	public List<Diary> findById(int id) {
		
		return dd.findById(id);
	}

	@Override
	public Diary saveDiary(Diary diary) {
		
		return dd.saveDiary(diary);
	}

	@Override
	public void deleteDiary(int id) {
		dd.deleteDiary(id);
		
	}

}
