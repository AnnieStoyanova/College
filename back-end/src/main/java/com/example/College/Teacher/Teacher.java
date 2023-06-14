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

    private String role;

    private String firstName;

    private String lastName;

    private String email;
    private String password;

    @OneToMany
    private List<Course> teacherCourses;


    public Teacher(String role, String firstName, String lastName, String email, String password, List<Course> teacherCourses) {
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.teacherCourses = teacherCourses;
    }

    public Teacher() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Course> getTeacherCourses() {
        return teacherCourses;
    }

    public void setTeacherCourses(List<Course> teacherCourses) {
        this.teacherCourses = teacherCourses;
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
                ", role='" + role + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", teacherCourses=" + teacherCourses +
                '}';
    }
}
