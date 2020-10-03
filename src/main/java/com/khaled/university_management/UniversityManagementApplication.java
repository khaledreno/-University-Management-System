package com.khaled.university_management;

import com.khaled.university_management.dao.CourseDAO;
import com.khaled.university_management.dao.StudentDAO;
import com.khaled.university_management.entity.Course;
import com.khaled.university_management.entity.Student;
import com.khaled.university_management.entity.Teacher;
import com.khaled.university_management.service.CourseService;
import com.khaled.university_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = BatchAutoConfiguration.class)
public class UniversityManagementApplication implements CommandLineRunner {

	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(UniversityManagementApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Student s1 = new Student("khaled","mohamed",5,"leo");
		Student s2 = new Student("ahmed","mansour",2,"lollaa");

		Course c1 = new Course("CS201",3);
		Course c2 = new Course("CS201",3);



		//courseService.AddCourse(c1);
		studentService.AddStudent(s1);
		//studentService.AddStudent(s2);

	}
}
