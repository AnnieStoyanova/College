package com.example.College.Student;

import com.example.College.Course.Course;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class StudentService {

    private StudentRepo studentRepository;

    public StudentService(StudentRepo studentRepository) {
        this.studentRepository = studentRepository;
    }

    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void saveStudentToDb(Student student) {
        try {
            studentRepository.saveAndFlush(student);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Student {} could not be saved in Database", student.getFirstName());
        }
    }

    public Optional<Student> findStudentByEmail(String email) {
        Optional<Student> student = studentRepository.findStudentByEmail(email);
        if (student.isPresent())
            return Optional.of(student.get());
        else {
            LOGGER.log(Level.WARNING, "Failed to find student in local DB for email: {}", email);
            return null;
        }
    }

    public Optional<Student> findStudentById(Long id) {
        Optional<Student> student = studentRepository.findStudentById(id);
        if (student.isPresent())
            return Optional.of(student.get());
        else {
            LOGGER.log(Level.WARNING, "Failed to find v in local DB for id: {}", id);
            return null;
        }
    }

    public void addNewStudent(Student student) {
        studentRepository.saveAndFlush(student);
    }

    public Collection<Student> findAllStudents() {
        return studentRepository.findAll();
    }

}