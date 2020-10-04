package com.khaled.university_management.controller;

import com.khaled.university_management.entity.Course;
import com.khaled.university_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    public List<Course> getAllCourses(){
        return courseService.GetAllCourses();
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourse(@PathVariable int id){
        return courseService.findCourse(id);
    }

    public Course AddCourse(@RequestBody Course c){
        courseService.AddCourse(c);
        return c;
    }
}
