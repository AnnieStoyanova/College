package com.example.College.Grade;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradeRepo extends JpaRepository<Grade,Long> {

    Optional<Grade> findGradeById(Long id);
}
