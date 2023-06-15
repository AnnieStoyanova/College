package com.example.College.Faculty;

import com.example.College.Course.Course;
import com.example.College.Department.Department;
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
        System.out.println(facultyService.findAll());
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

    @GetMapping(value = "/{facultyId}/departments")
    public Optional<List<Department>> getAllDepartments(@PathVariable("facultyId") Long facultyId) {
        return facultyService.findById(facultyId).map(Faculty::getDepartments);
    }

    @PutMapping(value = "/update/{facultyId}")
    public Optional<Object> updateDepartment(@PathVariable("facultyId") Long facultyId, @RequestBody Faculty newFaculty) {
        return facultyService.findById(facultyId)
                .map((faculty) -> {
                    faculty.setName(newFaculty.getName());
                    facultyService.addNewFaculty(faculty);
                    return null;
                });
    }

    @DeleteMapping(value = "/{facultyId}")
    public void deleteFaculty(@PathVariable("facultyId") Long facultyId) {
        facultyService.deleteFaculty(facultyId);
    }
}