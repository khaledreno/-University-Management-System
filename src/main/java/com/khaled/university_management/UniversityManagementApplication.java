package com.khaled.university_management;

import com.khaled.university_management.dao.TeacherDAO;
import com.khaled.university_management.entity.Student;
import com.khaled.university_management.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityManagementApplication.class, args);
	}


}
