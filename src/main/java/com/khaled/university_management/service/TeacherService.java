package com.khaled.university_management.service;

import com.khaled.university_management.dao.TeacherDAO;
import com.khaled.university_management.entity.Teacher;
import com.khaled.university_management.exception.TeacherExceptionMessages;
import com.khaled.university_management.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherDAO teacherDAO;

    public List<Teacher> getAllTeacher(){
        return teacherDAO.findAll();
    }

    public Teacher AddTeacher(Teacher t){
    return  teacherDAO.save(t);
    }

    public Optional<Teacher> findTeacher(@PathVariable int id){
        Teacher teacher = teacherDAO.findById(id).orElse(null);
        if(teacher == null) {
            throw new GeneralException(TeacherExceptionMessages.CANNOT_FIND_TEACHER);
        }
        else
            return teacherDAO.findById(id);
    }

    public void deleteTeacherByID(int id){
        teacherDAO.deleteById(id);
    }

}
