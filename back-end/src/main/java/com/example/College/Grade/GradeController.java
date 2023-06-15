package com.example.College.Grade;

import com.example.College.Course.Course;
import com.example.College.Faculty.Faculty;
import com.example.College.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentService studentService;

    public GradeController(GradeService gradeService, StudentService studentService) {
        this.gradeService = gradeService;
        this.studentService = studentService;
    }

    @PostMapping(value = "/add")
    public void addGrade(@RequestBody Grade grade) {
        this.gradeService.addNewGrade(grade);
    }

    @GetMapping("/{id}")
    public Optional<Grade> getGradeById(@PathVariable Long id){
        return gradeService.findGradeById(id);
    }

    @GetMapping("/getCourse/{gradeId}")
    public Optional<Course> getCourseNameOfGrade(@PathVariable Long gradeId){
         return Optional.ofNullable(gradeService.findGradeById(gradeId).get().getCourse());
    }

    @GetMapping("/all")
    private Collection<Grade> getAll(){
        return gradeService.findAllGrades();
    }

    @PutMapping(value = "/update/{gradeId}")
    public Optional<Object> updateGrade(@PathVariable("gradeId") Long gradeId, @RequestBody Grade newGrade) {
        return gradeService.findGradeById(gradeId)
                .map((grade) -> {
                    grade.setValue(newGrade.getValue());
                    gradeService.saveGradeToDb(grade);
                    return null;
                });
    }
    @DeleteMapping(value = "/deleteGradeFromStudent/{studentId}/{gradeId}")
    public void deleteGrade(@PathVariable("studentId") Long studentId,@PathVariable("gradeId") Long gradeId) {

        this.studentService.findStudentById(studentId).map(student -> {
            student.deleteGrade(gradeService.findGradeById(gradeId).get());
            return null;
        });
        gradeService.deleteGrade(gradeId);
    }
}
