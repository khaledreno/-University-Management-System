package com.khaled.university_management.controller;

import com.khaled.university_management.entity.Student;
import com.khaled.university_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> findAllStudent(){
    return studentService.findAllStudents();
    }

    @PostMapping("/students")
    public Student AddStudent(@RequestBody Student s){
    studentService.AddStudent(s);
    return s;
    }



}
