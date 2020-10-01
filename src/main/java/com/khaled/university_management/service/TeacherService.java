package com.khaled.university_management.service;

import com.khaled.university_management.dao.StudentDAO;
import com.khaled.university_management.dao.TeacherDAO;
import com.khaled.university_management.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private TeacherDAO teacherDAO;

    @Autowired
    public TeacherService (TeacherDAO teacherDAO){
        this.teacherDAO = teacherDAO;
    }

    public List<Teacher> getAllTeacher(){
        return teacherDAO.findAll();
    }

    public void AddTeacher(Teacher t){
        teacherDAO.save(t);
    }

    public Optional<Teacher> findTeacher(@PathVariable int id){
        if (teacherDAO.findById(id) == null){
            throw new RuntimeException("can't find a teacher with an id "+id);
        }
        else
            return teacherDAO.findById(id);
    }

    public void deleteTeacherByID(int id){
        teacherDAO.deleteById(id);
    }

}
