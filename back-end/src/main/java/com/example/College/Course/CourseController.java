package com.example.College.Course;

import com.example.College.Department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/course")

public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
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


    @DeleteMapping(value = "/{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId) {
        courseService.deleteCourse(courseId);
    }
}
