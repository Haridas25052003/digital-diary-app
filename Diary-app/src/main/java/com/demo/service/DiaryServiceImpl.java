package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.dao.DiaryDao;
import com.demo.model.Diary;

@Service
public class DiaryServiceImpl implements DiaryService {

    private final DiaryDao diaryDao;

    // ✅ Constructor Injection (replaces @Autowired field injection)
    public DiaryServiceImpl(DiaryDao diaryDao) {
        this.diaryDao = diaryDao;
    }

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
        return diaryDao.findByUser_Id(userId);
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