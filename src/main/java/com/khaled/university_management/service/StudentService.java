package com.khaled.university_management.service;

import com.khaled.university_management.dao.StudentDAO;
import com.khaled.university_management.entity.Student;
import com.khaled.university_management.entity.Teacher;
import com.khaled.university_management.exception.GeneralException;
import com.khaled.university_management.exception.StudentExceptionMessages;
import com.khaled.university_management.exception.TeacherExceptionMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    @Autowired
    private StudentDAO studentDAO;

    public List<Student> findAllStudents(){
        return studentDAO.findAll();
    }

    public void AddStudent(Student s){
        studentDAO.save(s);
    }

    public Optional<Student> findStudent(@PathVariable int id){
        Student student = studentDAO.findById(id).orElse(null);

        if (student == null){
            throw new GeneralException(StudentExceptionMessages.CANNOT_FIND_STUDENT);
        }
        else {
            return studentDAO.findById(id);
        }
    }

    public void deleteStudentbyID(int id){
        studentDAO.deleteById(id);
    }


}
