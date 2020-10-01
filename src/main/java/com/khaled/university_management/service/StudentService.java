package com.khaled.university_management.service;

import com.khaled.university_management.dao.StudentDAO;
import com.khaled.university_management.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentDAO studentDAO;

    @Autowired
    public StudentService (StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    public List<Student> findAllStudents(){
        return studentDAO.findAll();
    }

    public void AddStudent(Student s){
        studentDAO.save(s);
    }

    public Optional<Student> findStudent(@PathVariable int id){
        if (studentDAO.findById(id) == null){
            throw new RuntimeException("can't find a student with an id "+id);
        }
        else {
            return studentDAO.findById(id);
        }
    }

    public void deleteStudentbyID(int id){
        studentDAO.deleteById(id);
    }


}
