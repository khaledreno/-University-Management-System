package com.khaled.university_management.controller;


import com.khaled.university_management.entity.Teacher;
import com.khaled.university_management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    public ResponseEntity<?> findAllTeachers(){
    List<Teacher> teacherList = teacherService.getAllTeacher();
    return new ResponseEntity<>(teacherList,null, HttpStatus.OK);
}

    public ResponseEntity<?> addTeacher(@Valid @RequestBody Teacher t){
        Teacher teacher = teacherService.AddTeacher(t);
    teacherService.AddTeacher(t);
    return new ResponseEntity<>(teacher,null,HttpStatus.CREATED);

}

@GetMapping("/{id}")
public ResponseEntity<?> findTeacherByID(@PathVariable int id){
    Optional<Teacher> teacher = teacherService.findTeacher(id);
    return new ResponseEntity<>(teacher,null,HttpStatus.OK);
}
}
