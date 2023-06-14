package com.example.College.Department;

import com.example.College.Course.Course;
import com.example.College.Faculty.Faculty;
import com.example.College.Teacher.Teacher;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="department")

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String name;

    @OneToOne
    private Teacher headOfDepartment;

    @OneToMany
    private List<Course> courses;

    @ManyToOne
    private Faculty faculty;

    public Department(String name, Teacher headOfDepartment, List<Course> courses, Faculty faculty) {
        this.name = name;
        this.headOfDepartment = headOfDepartment;
        this.courses = courses;
        this.faculty = faculty;
    }
    public Department() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addCourseToDepartment(Course course){
        this.courses.add(course);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Teacher headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headOfDepartment=" + headOfDepartment +
                ", courses=" + courses +
                ", faculty=" + faculty +
                '}';
    }
}
