package com.example.College.Department;

import com.example.College.Course.Course;
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

    public Department(String name, Teacher headOfDepartment, List<Course> courses) {
        this.name = name;
        this.headOfDepartment = headOfDepartment;
        this.courses = courses;
    }

    public Department() {
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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headOfDepartment=" + headOfDepartment +
                ", courses=" + courses +
                '}';
    }
}
