package com.example.College.Faculty;

import com.example.College.Department.Department;
import com.example.College.Profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FacultyRepo extends JpaRepository<Faculty,Long> {

    Optional<Profile> findFacultyById(Long id);
}

