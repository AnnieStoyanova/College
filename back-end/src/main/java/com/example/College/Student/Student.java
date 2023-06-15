package com.example.College.Student;

import com.example.College.Course.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
   // private Map<Course, List<Double>> grades;
    private Double absences;


    public Student(String role, String firstName, String lastName, String email, String password, Double absences) {
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        //this.grades = grades;
        this.absences = absences;
    }

    public Student() {
    }

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

//    public Map<Course, List<Double>> getGrades() {
//        return grades;
//    }
//
//    public void setGrades(Map<Course, List<Double>> grades) {
//        this.grades = grades;
//    }

    public Double getAbsences() {
        return absences;
    }

    public void setAbsences(Double absences) {
        this.absences = absences;
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
//                ", grades=" + grades +
                ", absences=" + absences +
                '}';
    }
}