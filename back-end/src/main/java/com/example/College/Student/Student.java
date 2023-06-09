package com.example.College.Student;

import com.example.College.Course.Course;
import com.example.College.Grade.Grade;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String role;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany
    private List<Course> courses;
    @OneToMany
    private List<Grade> grades;
    private Double absences;


    public Student(String role, String firstName, String lastName, String email, String password, List<Course> courses, List<Grade> grades, Double absences) {
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.courses = courses;
        this.grades = grades;
        this.absences = absences;
    }

    public Student() {
    }

    public void addGradeToStudent(Grade grade) {
        this.grades.add(grade);
    }
    public void deleteGrade(Grade grade){this.grades.remove(grade);}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Double getAbsences() {
        return absences;
    }

    public void setAbsences(Double absences) {
        this.absences = absences;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", courses=" + courses +
                ", grades=" + grades +
                ", absences=" + absences +
                '}';
    }
}