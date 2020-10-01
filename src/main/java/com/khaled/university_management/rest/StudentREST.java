package com.khaled.university_management.rest;

import com.khaled.university_management.entity.Student;
import com.khaled.university_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentREST {
    private StudentService studentService;

@Autowired
    public StudentREST(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> findAllStudent(){
    return studentService.findAllStudents();
    }

    @PostMapping("/students")
    public Student AddStudent(@RequestBody Student s){
    s.setId(0);
    studentService.AddStudent(s);
    return s;
    }



}
