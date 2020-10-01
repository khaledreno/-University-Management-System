package com.khaled.university_management.dao;

import com.khaled.university_management.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends JpaRepository<Course,Integer> {
}
