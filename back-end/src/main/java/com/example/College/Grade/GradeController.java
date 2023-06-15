package com.example.College.Grade;

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

    @GetMapping("/{id}")
    public Optional<Grade> getGradeById(@PathVariable Long id){
        return gradeService.findGradeById(id);
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
    @DeleteMapping(value = "/delete/{gradeId}")
    public void deleteGrade(@PathVariable("gradeId") Long gradeId) {
        gradeService.deleteGrade(gradeId);
    }
}
