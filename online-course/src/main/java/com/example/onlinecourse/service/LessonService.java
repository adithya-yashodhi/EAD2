package com.example.onlinecourse.service;

import com.example.onlinecourse.data.Course;
import com.example.onlinecourse.data.Lesson;
import com.example.onlinecourse.data.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public Lesson getLessonById(int lessonId){
        Optional<Lesson> lessonObj = lessonRepository.findById(lessonId);
        if(lessonObj.isPresent()){
            return lessonObj.get();
        }
        else {
            return null;
        }
    }
}