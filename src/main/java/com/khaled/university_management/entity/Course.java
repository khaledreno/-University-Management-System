package com.khaled.university_management.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int course_id;

    @Column(name="course_name")
    @NotBlank
    private String course_name;

    @Column(name = "course_hours")
    @NotBlank
    private int course_hours;

    //Relation between teachers and courses
    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="instructor_course",
            joinColumns=@JoinColumn(name="course_id"),
            inverseJoinColumns=@JoinColumn(name="instructor_id"))
    private Set<Teacher> teacher = new HashSet<>();


    //Relation between students and courses
    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="student_course",
            joinColumns=@JoinColumn(name="course_id"),
            inverseJoinColumns=@JoinColumn(name="student_id"))
    private Set<Student> students = new HashSet<>();

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

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(Set<Teacher> teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", course_hours=" + course_hours +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}
