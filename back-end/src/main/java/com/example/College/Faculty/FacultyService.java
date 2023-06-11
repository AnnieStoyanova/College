package com.example.College.Faculty;

import com.example.College.Course.Course;
import com.example.College.Department.Department;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    private final FacultyRepo facultyRepo;

    @Autowired
    public FacultyService(FacultyRepo facultyRepo) {
        this.facultyRepo = facultyRepo;
    }

    public List<Faculty> findAll(){
        return facultyRepo.findAll();
    }
    public Optional<Faculty> findById(Long id){
        return facultyRepo.findById(id);
    }

    public void addNewFaculty(Faculty faculty) {
        facultyRepo.saveAndFlush(faculty);
    }


    @Transactional
    public void deleteFaculty(Long facultyId) {
        boolean exists = facultyRepo.existsById(facultyId);
        if(!exists){
            throw new IllegalArgumentException("Faculty with id" + facultyId + "does not exist");
        }
        facultyRepo.deleteById(facultyId);
    }
}
