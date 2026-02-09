package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Diary;
import com.demo.service.DiaryService;

@RestController
@RequestMapping("/api/diaries")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    // Create diary
    @PostMapping
    public Diary createDiary(@RequestBody Diary diary) {
        return diaryService.saveDiary(diary);
    }

    // Get all diaries
    @GetMapping
    public List<Diary> getAllDiaries() {
        return diaryService.getAllDiaries();
    }

    // Get diary by ID
    @GetMapping("/{id}")
    public Diary getDiaryById(@PathVariable int id) {
        return diaryService.getDiaryById(id).orElse(null);
    }

    // Get diaries by user ID
    @GetMapping("/user/{userId}")
    public List<Diary> getDiariesByUser(@PathVariable int userId) {
        return diaryService.getDiariesByUserId(userId);
    }

    // Delete diary
    @DeleteMapping("/{id}")
    public String deleteDiary(@PathVariable int id) {
        diaryService.deleteDiary(id);
        return "Diary deleted successfully";
    }
}
