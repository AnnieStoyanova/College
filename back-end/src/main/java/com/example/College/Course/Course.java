package com.example.College.Course;

import com.example.College.Department.Department;
import com.example.College.Teacher.Teacher;
import jakarta.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String name;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Department department;

    public Course() {
    }

    public Course(String name, Teacher teacher, Department department) {
        this.name = name;
        this.teacher = teacher;
        this.department = department;
    }

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", department=" + department +
                '}';
    }
}
