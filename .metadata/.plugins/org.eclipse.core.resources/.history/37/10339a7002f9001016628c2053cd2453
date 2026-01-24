package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Diary;
import com.demo.service.DiaryService;

@RestController
@RequestMapping("/api/diary")   // important to avoid mapping conflict
public class DiaryController {

    @Autowired
    private DiaryService ds;

    @GetMapping("/all")
    public List<Diary> getAllDiaries() {
        return ds.findAll();
    }

    @GetMapping("/dreq/{userId}")
    public List<Diary> getDiariesByUserId(@PathVariable int userId) {
        return ds.findByUserId(userId);
    }
 
    @GetMapping("/dreq1/{id}")
    public List<Diary> getDiaryById(@PathVariable int id) {
        return ds.findById(id);
    }

    @PostMapping("/dreq2/save")
    public Diary saveDiary(@RequestBody Diary diary) {
        return ds.saveDiary(diary);
    }
    
    @DeleteMapping("/dreq3/{id}")
    public String deleteDiary(@PathVariable int id) {
        ds.deleteDiary(id);
        return "Diary deleted successfully";
    }
}
