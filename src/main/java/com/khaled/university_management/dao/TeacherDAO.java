package com.khaled.university_management.dao;

import com.khaled.university_management.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher,Integer> {
}
