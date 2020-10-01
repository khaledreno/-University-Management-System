package com.khaled.university_management.rest;

import com.khaled.university_management.entity.Course;
import com.khaled.university_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseREST {

    private CourseService courseService;

    @Autowired
    CourseREST(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping("/course")
    public List<Course> getAllCourses(){
        return courseService.GetAllCourses();
    }

    @GetMapping("/course/{id}")
    public Optional<Course> getCourse(@PathVariable int id){
        return courseService.findCourse(id);
    }

    @PostMapping("/courses")
    public Course AddCourse(@RequestBody Course c){
        c.setCourse_id(0);
        courseService.AddCourse(c);
        return c;
    }
}
