package com.example.onlinecourse.controller;

import com.example.onlinecourse.data.Document;
import com.example.onlinecourse.data.Lesson;
import com.example.onlinecourse.data.Video;
import com.example.onlinecourse.service.DocumentService;
import com.example.onlinecourse.service.LessonService;
import com.example.onlinecourse.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping("/api/lessons/{lessonId}")
    public ResponseEntity<Lesson> getLessonData(@PathVariable("lessonId") int lessonId) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        if (lesson != null) {
            return ResponseEntity.ok(lesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
