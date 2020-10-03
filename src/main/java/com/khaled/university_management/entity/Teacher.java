package com.khaled.university_management.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "number_active_subjects")
    private int number_active_subjects;

    @Column(name = "title")
    private String title;

    //Relation between teacher and students
    @OneToMany(mappedBy = "instructor"
    ,cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.REFRESH , CascadeType.PERSIST})
    private Set<Student> std = new HashSet<>();

    //Relation between teachers and courses
    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="instructor_course",
            joinColumns=@JoinColumn(name="instructor_id"),
            inverseJoinColumns=@JoinColumn(name="course_id"))
    private Set<Course> course = new HashSet<>();

    public Teacher() {
    }

    public Teacher(String first_name, String last_name, int number_active_subjects, String title) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.number_active_subjects = number_active_subjects;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getNumber_active_subjects() {
        return number_active_subjects;
    }

    public void setNumber_active_subjects(int number_active_subjects) {
        this.number_active_subjects = number_active_subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Student> getStd() {
        return std;
    }

    public void setStd(Set<Student> std) {
        this.std = std;
    }

    public Set<Course> getCourse() {
        return course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }
}
