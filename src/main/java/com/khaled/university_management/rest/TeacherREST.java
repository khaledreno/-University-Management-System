package com.khaled.university_management.rest;


import com.khaled.university_management.entity.Teacher;
import com.khaled.university_management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherREST {
private TeacherService teacherService;

@Autowired
public TeacherREST(TeacherService teacherService){
    this.teacherService = teacherService;
}

@GetMapping("/teacher")
    public List<Teacher> findAllTeachers(){
    return teacherService.getAllTeacher();
}

@PostMapping("/teacher")
    public Teacher addTeacher(@RequestBody Teacher t){
    t.setId(0);
    teacherService.AddTeacher(t);
    return t;

}

}
