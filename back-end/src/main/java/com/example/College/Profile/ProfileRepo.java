package com.example.College.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepo extends JpaRepository<Profile,Long> {
    Optional<Profile> findProfileById(Long id);
    Optional<Profile> findProfileByEmail(String email);
}