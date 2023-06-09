package com.example.College.Teacher;

import com.example.College.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/teacher")

public class TeacherController {

    private TeacherService teacherService;
    private CourseService courseService;

    @Autowired
    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }

    @PostMapping(value = "/add")
    public void addTeacher(@RequestBody Teacher teacher) {
        teacherService.addNewTeacher(teacher);
    }

    @PatchMapping(value = "/addCourse/{teacherId}/{courseId}")
    public Optional<Object> addCourse(@PathVariable("teacherId") Long teacherId, @PathVariable("courseId") Long courseId) {
        return teacherService.findById(teacherId).map(teacher -> {
            teacher.addCourse(courseService.findById(courseId).get());
            teacherService.addNewTeacher(teacher);
            return teacher;
        });
    }

    @PutMapping(value = "/update/{teacherId}")
    public Optional<Object> updateTeacher(@PathVariable("teacherId") Long teacherId, @RequestBody Teacher newTeacher) {
        return teacherService.findById(teacherId)
                .map((teacher) -> {
                    teacher.setFirstName(newTeacher.getFirstName());
                    teacher.setLastName(newTeacher.getLastName());
                    teacherService.addNewTeacher(teacher);
                    return null;
                });
    }

    @DeleteMapping(value = "/{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }
}

