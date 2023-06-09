package com.example.College.Teacher;

import com.example.College.Course.Course;
import com.example.College.Department.Department;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="teacher")

public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String firstName;

    private String lastName;

    @OneToMany
    private List<Course> teacherCourses;


    public Teacher(String firstName, String lastName, List<Course> teacherCourses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacherCourses = teacherCourses;
    }

    public Teacher() {
    }

    public void addCourse(Course course){
        teacherCourses.add(course);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Course> getCourses() {
        return teacherCourses;
    }

    public void setCourses(List<Course> courses) {
        this.teacherCourses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teacherCourses=" + teacherCourses +
                '}';
    }
}
