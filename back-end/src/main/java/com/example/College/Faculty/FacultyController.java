package com.example.College.Faculty;

import com.example.College.Course.Course;
import com.example.College.Department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/faculty")

public class FacultyController {

    private FacultyService facultyService;
    private DepartmentService departmentService;
    @Autowired
    public FacultyController(FacultyService facultyService, DepartmentService departmentService) {
        this.facultyService = facultyService;
        this.departmentService = departmentService;
    }


    @GetMapping(value = "/all")
    public List<Faculty> findAll(){
        return facultyService.findAll();
    }
    @PostMapping(value = "/add")
    public void addFaculty(@RequestBody Faculty faculty) {
        this.facultyService.addNewFaculty(faculty);
    }

    @PatchMapping(value = "/addDepartmentToFaculty/{facultyId}/{departmentId}")
    public Optional<Object> addDepartment(@PathVariable("facultyId") Long facultyId, @PathVariable("departmentId") Long departmentId) {
        return facultyService.findById(facultyId).map(faculty -> {
            faculty.addDepartment(departmentService.findById(departmentId).get());
            facultyService.addNewFaculty(faculty);
            return faculty;
        });
    }

//    @PutMapping(value = "/update/{departmentId}")
//    public Optional<Object> updateDepartment(@PathVariable("departmentId") Long departmentId, @RequestBody Department newDepartment) {
//        return departmentService.findById(departmentId)
//                .map((department) -> {
//                    department.setName(newDepartment.getName());
//                    department.setCourses(newDepartment.getCourses());
//                    department.setHeadOfDepartment(newDepartment.getHeadOfDepartment());
//                    departmentService.addNewDepartment(department);
//                    return null;
//                });
//    }

    @DeleteMapping(value = "/{facultyId}")
    public void deleteFaculty(@PathVariable("departmentId") Long facultyId) {
        facultyService.deleteFaculty(facultyId);
    }
}
