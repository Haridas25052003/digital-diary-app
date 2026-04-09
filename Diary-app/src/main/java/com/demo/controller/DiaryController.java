package com.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.Diary;
import com.demo.model.User;
import com.demo.service.DiaryService;
import com.demo.service.UserService;

@RestController
@RequestMapping("/api/diaries")
@CrossOrigin(origins = "*")   // Allow frontend calls during development
public class DiaryController {

    private static final Logger logger = LoggerFactory.getLogger(DiaryController.class);

    private final DiaryService diaryService;
    private final UserService userService;

    // ✅ Constructor Injection
    public DiaryController(DiaryService diaryService, UserService userService) {
        this.diaryService = diaryService;
        this.userService = userService;
    }

    // ✅ CREATE DIARY
    // Frontend sends { title, content, category, userId }
    @PostMapping
    public ResponseEntity<Diary> createDiary(@Valid @RequestBody Diary diary) {
        logger.info("Creating diary for userId: {}", diary.getUserId());

        // Resolve User from transient userId field
        User user = userService.getUserById(diary.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + diary.getUserId()));

        diary.setUser(user);

        Diary savedDiary = diaryService.saveDiary(diary);
        logger.info("Diary created with ID: {}", savedDiary.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(savedDiary);
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
                .orElseThrow(() -> new ResourceNotFoundException("Diary not found with ID: " + id));

        return ResponseEntity.ok(diary);
    }

    // ✅ GET DIARIES BY USER ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Diary>> getDiariesByUser(@PathVariable int userId) {
        logger.info("Fetching diaries for user ID: {}", userId);

        // Validate user exists
        userService.getUserById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        return ResponseEntity.ok(diaryService.getDiariesByUserId(userId));
    }

    // ✅ FILTER BY CATEGORY
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Diary>> getDiariesByCategory(@PathVariable String category) {
        logger.info("Fetching diaries by category: {}", category);
        return ResponseEntity.ok(diaryService.getDiariesByCategory(category));
    }

    // ✅ UPDATE DIARY (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Diary> updateDiary(@PathVariable int id,
                                             @Valid @RequestBody Diary updatedDiary) {
        logger.info("Updating diary ID: {}", id);

        Diary diary = diaryService.getDiaryById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diary not found with ID: " + id));

        diary.setTitle(updatedDiary.getTitle());
        diary.setContent(updatedDiary.getContent());
        diary.setCategory(updatedDiary.getCategory());

        Diary saved = diaryService.saveDiary(diary);
        logger.info("Diary updated: ID {}", saved.getId());

        return ResponseEntity.ok(saved);
    }

    // ✅ DELETE DIARY
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiary(@PathVariable int id) {
        logger.info("Deleting diary ID: {}", id);

        diaryService.getDiaryById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diary not found with ID: " + id));

        diaryService.deleteDiary(id);
        logger.info("Diary deleted: ID {}", id);

        return ResponseEntity.ok("Diary deleted successfully");
    }
}