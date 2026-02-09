package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.DiaryDao;
import com.demo.model.Diary;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryDao diaryDao;

    @Override
    public Diary saveDiary(Diary diary) {
        return diaryDao.save(diary);
    }

    @Override
    public List<Diary> getAllDiaries() {
        return diaryDao.findAll();
    }

    @Override
    public Optional<Diary> getDiaryById(int id) {
        return diaryDao.findById(id);
    }

    @Override
    public List<Diary> getDiariesByUserId(int userId) {
        return diaryDao.findByUserId(userId);
    }

    @Override
    public List<Diary> getDiariesByCategory(String category) {
        return diaryDao.findByCategory(category);
    }

    @Override
    public void deleteDiary(int id) {
        diaryDao.deleteById(id);
    }
}
