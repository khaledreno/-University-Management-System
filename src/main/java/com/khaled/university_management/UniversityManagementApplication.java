package com.khaled.university_management;

import com.khaled.university_management.dao.CourseDAO;
import com.khaled.university_management.dao.StudentDAO;
import com.khaled.university_management.entity.Course;
import com.khaled.university_management.entity.Student;
import com.khaled.university_management.entity.Teacher;
import com.khaled.university_management.service.CourseService;
import com.khaled.university_management.service.StudentService;
import com.khaled.university_management.service.TeacherService;
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

	@Autowired
	private TeacherService teacherService;

	public static void main(String[] args) {
		SpringApplication.run(UniversityManagementApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		//initialize values to objects
		Student s1 = new Student("khaled","mohamed",5,"leo");
		//Student s2 = new Student("ahmed","mansour",2,"lollaa");

	//	Course c1 = new Course("CS201",3);
		Course c1 = new Course("ENG102",1);

		Teacher t1 = new Teacher("Hana","Ahmed",4,"TA");


		//relating student object with course objects
		//courseService.AddCourse(c1);
		//studentService.AddStudent(s1);
		//studentService.AddStudent(s2);

		//s1.getCourses().add(c1);

		//c1.getStudents().add(s1);

		//studentService.AddStudent(s1);
		//courseService.AddCourse(c1);

		//connecting teacher with a course




		t1.getCourse().add(c1);
		c1.getTeacher().add(t1);

		teacherService.AddTeacher(t1);
		courseService.AddCourse(c1);
	}
}
