package com.example.onlinecourse.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    @Query("SELECT l FROM Lesson l JOIN FETCH l.course")
    List<Lesson> findAllWithCourseInfo();
}
