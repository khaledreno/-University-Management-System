package com.khaled.university_management.service;

import com.khaled.university_management.dao.CourseDAO;
import com.khaled.university_management.entity.Course;
import com.khaled.university_management.exception.CourseExceptionMessages;
import com.khaled.university_management.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseDAO courseDAO;


    public void AddCourse(Course course){
        courseDAO.save(course);
    }

    public List<Course> GetAllCourses(){
       return courseDAO.findAll();
    }

    public Optional<Course> findCourse(@PathVariable int id){
        Course course = courseDAO.findById(id).orElse(null);
        if (course == null){
            throw new GeneralException(CourseExceptionMessages.CANNOT_FIND_COURSE);
        }
        else
            return courseDAO.findById(id);
    }

    public void DeleteCourse(int id){
        courseDAO.deleteById(id);
    }
}
