package com.example.College.Faculty;

import com.example.College.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepo extends JpaRepository<Faculty,Long> {

    Optional<Student> findFacultyById(Long id);
}

