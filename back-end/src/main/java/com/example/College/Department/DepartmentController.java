package com.example.College.Department;

import com.example.College.Course.Course;
import com.example.College.Course.CourseService;
import com.example.College.Faculty.Faculty;
import com.example.College.Teacher.Teacher;
import com.example.College.Teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/department")

public class DepartmentController {

    private DepartmentService departmentService;
    private CourseService courseService;
    private TeacherService teacherService;

    @Autowired
    public DepartmentController(DepartmentService departmentService, CourseService courseService, TeacherService teacherService) {
        this.departmentService = departmentService;
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @GetMapping(value = "/all")
    public List<Department> findAll(){
       return departmentService.findAll();
    }

    @PostMapping(value = "/add")
    public void addDepartment(@RequestBody Department department){
        this.departmentService.addNewDepartment(department);
    }

    @PatchMapping(value = "/addCourseToDepartment/{departmentId}/{courseId}")
    public Optional<Object> addCourse(@PathVariable("departmentId") Long departmentId, @PathVariable("courseId") Long courseId){
        return departmentService.findById(departmentId).map(department -> {
            department.addCourseToDepartment(courseService.findById(courseId).get());
            departmentService.addNewDepartment(department);
            return department;
        });
    }

    @PatchMapping(value = "/addHeadOfDepartment/{departmentId}/{teacherId}")
    public Optional<Object> addHeadOfDepartment(@PathVariable("departmentId") Long departmentId, @PathVariable("teacherId") Long teacherId){
        return departmentService.findById(departmentId).map(department -> {
            department.setHeadOfDepartment(teacherService.findById(teacherId).get());
            departmentService.addNewDepartment(department);
            return department;
        });
    }

    @PutMapping(value = "/update/{departmentId}")
    public Optional<Object> updateDepartment(@PathVariable("departmentId") Long departmentId, @RequestBody Department newDepartment) {
        return departmentService.findById(departmentId)
                .map((department) -> {
                    department.setName(newDepartment.getName());
                    department.setCourses(newDepartment.getCourses());
                    department.setHeadOfDepartment(newDepartment.getHeadOfDepartment());
                    departmentService.addNewDepartment(department);
                    return null;
                });
    }

    @GetMapping(value = "/{departmentId}/courses")
    public Optional<List<Course>> getAllCourses(@PathVariable("departmentId") Long departmentId) {
        return departmentService.findById(departmentId).map(Department::getCourses);
    }

    @DeleteMapping(value = "/{departmentId}")
    public void deleteDepartment(@PathVariable("departmentId") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
    }
}
