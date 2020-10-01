package com.khaled.university_management.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int course_id;

    @Column(name="course_name")
    private String course_name;

    @Column(name = "course_hours")
    private int course_hours;

    //Relation between teachers and courses
    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="instructor_course",
            joinColumns=@JoinColumn(name="course_id"),
            inverseJoinColumns=@JoinColumn(name="instructor_id"))
    private List<Teacher> teacher;


    //Relation between students and courses
    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="student_course",
            joinColumns=@JoinColumn(name="course_id"),
            inverseJoinColumns=@JoinColumn(name="student_id"))
    private List<Student> students;

    public Course() {
    }

    public Course(String course, int course_hours) {
        this.course_name = course;
        this.course_hours = course_hours;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse() {
        return course_name;
    }

    public void setCourse(String course) {
        this.course_name = course;
    }

    public int getCourse_hours() {
        return course_hours;
    }

    public void setCourse_hours(int course_hours) {
        this.course_hours = course_hours;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student theStudent) {

        if (students == null) {
            students = new ArrayList<>();
        }

        students.add(theStudent);
    }

    public void addInstructor(Teacher theTeacher) {

        if (teacher == null) {
            teacher = new ArrayList<>();
        }

        teacher.add(theTeacher);
    }
}
