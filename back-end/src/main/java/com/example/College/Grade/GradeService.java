package com.example.College.Grade;
import com.example.College.Faculty.FacultyRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class GradeService
{
    @Autowired
    private GradeRepo gradeRepo;

    @Autowired
    public GradeService(GradeRepo gradeRepo) {
        this.gradeRepo = gradeRepo;
    }
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void saveGradeToDb(Grade grade) {
        try {
            gradeRepo.saveAndFlush(grade);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Grade {} could not be saved in Database", grade.getId());
        }
    }

    public Optional<Grade> findGradeById(Long id) {
        Optional<Grade> grade = gradeRepo.findGradeById(id);
        if (grade.isPresent())
            return Optional.of(grade.get());
        else {
            LOGGER.log(Level.WARNING, "Failed to find grade in local DB for id: {}", id);
            return null;
        }
    }

    public Collection<Grade> findAllGrades() {
        return gradeRepo.findAll();
    }

    @Transactional
    public void deleteGrade(Long gradeId) {
        boolean exists = gradeRepo.existsById(gradeId);
        if(!exists){
            throw new IllegalArgumentException("Grade with id" + gradeId + "does not exist");
        }
        gradeRepo.deleteById(gradeId);
    }
}
