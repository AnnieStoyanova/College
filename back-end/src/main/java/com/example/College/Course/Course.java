package com.example.College.Course;

import com.example.College.Department.Department;
import com.example.College.Student.Student;
import com.example.College.Teacher.Teacher;
import jakarta.persistence.*;

import java.util.List;

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

    @ManyToMany
    private List<Student> students;

    private String data;

    public Course() {
    }

    public Course(String name, Teacher teacher, Department department, List<Student> students, String data) {
        this.name = name;
        this.teacher = teacher;
        this.department = department;
        this.students = students;
        this.data = data;
    }

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public void addStudentToCourse(Student student) {
        this.students.add(student);
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", department=" + department +
                ", students=" + students +
                ", data='" + data + '\'' +
                '}';
    }
}
