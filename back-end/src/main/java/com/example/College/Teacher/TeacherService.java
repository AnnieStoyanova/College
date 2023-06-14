package com.example.College.Teacher;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepo teacherRepo;

    @Autowired
    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public Optional<Teacher> findById(Long id){
        return teacherRepo.findById(id);
    }

    public Optional<Teacher> findTeacherByEmail(String email){
        return teacherRepo.findTeacherByEmail(email);
    }

    public void addNewTeacher(Teacher teacher) {
        teacherRepo.saveAndFlush(teacher);
    }

    @Transactional
    public void deleteTeacher(Long teacherId) {
        boolean exists = teacherRepo.existsById(teacherId);
        if(!exists){
            throw new IllegalArgumentException("Teacher with id" + teacherId + "does not exist");
        }
        teacherRepo.deleteById(teacherId);
    }

}
