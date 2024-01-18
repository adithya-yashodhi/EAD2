package com.example.onlinecourse.service;

import com.example.onlinecourse.data.Course;
import com.example.onlinecourse.data.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course getCourseById(int courseId){
        Optional<Course> courseObj = courseRepository.findById(courseId);
        if(courseObj.isPresent())
        {
            return courseObj.get();
        }
        else {
            return null;
        }
    }

    public Course updateCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    public void deleteCourse(int courseId){
        courseRepository.deleteById(courseId);
    }

}
