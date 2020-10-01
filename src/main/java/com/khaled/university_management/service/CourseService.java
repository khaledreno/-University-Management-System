package com.khaled.university_management.service;

import com.khaled.university_management.dao.CourseDAO;
import com.khaled.university_management.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private CourseDAO courseDAO;

    @Autowired
    CourseService(CourseDAO courseDAO){
        this.courseDAO = courseDAO;
    }

    public void AddCourse(Course course){
        courseDAO.save(course);
    }

    public List<Course> GetAllCourses(){
       return courseDAO.findAll();
    }

    public Optional<Course> findCourse(@PathVariable int id){
        if (courseDAO.findById(id) == null){
            throw new RuntimeException("course not found with id "+id);
        }
        else
            return courseDAO.findById(id);
    }

    public void DeleteCourse(int id){
        courseDAO.deleteById(id);
    }
}
