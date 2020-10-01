package com.khaled.university_management;

import com.khaled.university_management.dao.CourseDAO;
import com.khaled.university_management.dao.StudentDAO;
import com.khaled.university_management.dao.TeacherDAO;
import com.khaled.university_management.entity.Course;
import com.khaled.university_management.entity.Student;
import com.khaled.university_management.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;

@SpringBootApplication(exclude = BatchAutoConfiguration.class)
public class UniversityManagementApplication implements CommandLineRunner {

	@Autowired
	private CourseDAO courseDAO;

	@Autowired
	private StudentDAO studentDAO;

	public static void main(String[] args) {
		SpringApplication.run(UniversityManagementApplication.class, args);




	}


	@Override
	public void run(String... args) throws Exception {

		Student s1 = new Student("khaled","mohamed",5,"sdada");
		Student s2 = new Student("ahmed","mansour",2,"gggdw");

		Course c1 = new Course("CS101",3);

		c1.getStudents().add(s1);
		c1.getStudents().add(s2);


	}
}
