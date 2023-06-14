package com.example.College.Teacher;

import com.example.College.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {

    Optional<Teacher> findTeacherById(Long id);
    Optional<Teacher> findTeacherByEmail(String email);
}
