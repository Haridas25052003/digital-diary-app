package com.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Diary;
import com.demo.service.DiaryService;

@RestController
@RequestMapping("/api/diaries")
public class DiaryController {

    private static final Logger logger = LoggerFactory.getLogger(DiaryController.class);

    private final DiaryService diaryService;

    // ✅ Constructor Injection
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    // ✅ CREATE DIARY
    @PostMapping
    public ResponseEntity<Diary> createDiary(@Valid @RequestBody Diary diary) {

        logger.info("Creating diary with title: {}", diary.getTitle());

        Diary savedDiary = diaryService.saveDiary(diary);

        logger.info("Diary created successfully with ID: {}", savedDiary.getId());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedDiary);
    }

    // ✅ GET ALL DIARIES
    @GetMapping
    public ResponseEntity<List<Diary>> getAllDiaries() {

        logger.info("Fetching all diaries");

        return ResponseEntity.ok(diaryService.getAllDiaries());
    }

    // ✅ GET DIARY BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Diary> getDiaryById(@PathVariable int id) {

        logger.info("Fetching diary by ID: {}", id);

        Diary diary = diaryService.getDiaryById(id)
                .orElseThrow(() -> new RuntimeException("Diary not found with ID: " + id));

        return ResponseEntity.ok(diary);
    }

    // ✅ GET DIARIES BY USER ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Diary>> getDiariesByUser(@PathVariable int userId) {

        logger.info("Fetching diaries for user ID: {}", userId);

        return ResponseEntity.ok(diaryService.getDiariesByUserId(userId));
    }

    // ✅ FILTER BY CATEGORY (NEW)
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Diary>> getDiariesByCategory(@PathVariable String category) {

        logger.info("Fetching diaries by category: {}", category);

        return ResponseEntity.ok(diaryService.getDiariesByCategory(category));
    }

    // ✅ UPDATE DIARY (NEW - VERY IMPORTANT 🔥)
    @PutMapping("/{id}")
    public ResponseEntity<Diary> updateDiary(@PathVariable int id,
                                             @Valid @RequestBody Diary updatedDiary) {

        logger.info("Updating diary with ID: {}", id);

        Diary diary = diaryService.getDiaryById(id)
                .orElseThrow(() -> new RuntimeException("Diary not found with ID: " + id));

        diary.setTitle(updatedDiary.getTitle());
        diary.setContent(updatedDiary.getContent());
        diary.setCategory(updatedDiary.getCategory());

        Diary savedDiary = diaryService.saveDiary(diary);

        logger.info("Diary updated successfully with ID: {}", savedDiary.getId());

        return ResponseEntity.ok(savedDiary);
    }

    // ✅ DELETE DIARY
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiary(@PathVariable int id) {

        logger.info("Deleting diary with ID: {}", id);

        diaryService.deleteDiary(id);

        logger.info("Diary deleted successfully with ID: {}", id);

        return ResponseEntity.ok("Diary deleted successfully");
    }
}