package com.example.College.Course;

import com.example.College.Department.Department;
import com.example.College.Faculty.Faculty;
import com.example.College.Student.Student;
import com.example.College.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/course")

public class CourseController {

    private CourseService courseService;

    private StudentService studentService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(value = "/all")
    public List<Course> findAll(){
        return courseService.findAll();
    }
    @PostMapping(value = "/add")
    public void addCourse(@RequestBody Course course) {
        courseService.addNewCourse(course);
    }

    @PutMapping(value = "/update/{courseId}")
    public Optional<Object> updateCourse(@PathVariable("courseId") Long courseId, @RequestBody Course newCourse) {
        return courseService.findById(courseId)
                .map((course) -> {
                    course.setName(newCourse.getName());
                    course.setDepartment(newCourse.getDepartment());
                    course.setTeacher(newCourse.getTeacher());
                    courseService.addNewCourse(course);
                    return null;
                });
    }

    @GetMapping(value = "/{courseId}/students")
    public Optional<List<Student>> getAllStudents(@PathVariable("courseId") Long courseId) {
        return courseService.findById(courseId).map(Course::getStudents);
    }

    @PatchMapping(value = "/addStudentToCourse/{courseId}/{studentId}")
    public Optional<Object> addStudent(@PathVariable("courseId") Long courseId, @PathVariable("studentId") Long studentId){
        return courseService.findById(courseId).map(course -> {
            course.addStudentToCourse(studentService.findStudentById(studentId).get());
            courseService.addNewCourse(course);
            return course;
        });
    }


    @DeleteMapping(value = "/delete/{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId) {
        courseService.deleteCourse(courseId);
    }
}
