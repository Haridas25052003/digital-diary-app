package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Diary;

public interface DiaryDao extends JpaRepository<Diary,Integer>{

	List<Diary> findByUserId(int userId);

    List<Diary> findByCategory(String category);
}
