package com.example.College.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo profileRepository;
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void saveProfileToDb(Profile profile) {
        try {
            profileRepository.saveAndFlush(profile);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Profile {} could not be saved in Database", profile.getName());
        }
    }

    public Optional<Profile> findProfileByEmail(String email) {
        Optional<Profile> profile = profileRepository.findProfileByEmail(email);
        if (profile.isPresent())
            return Optional.of(profile.get());
        else {
            LOGGER.log(Level.WARNING, "Failed to find profile in local DB for email: {}", email);
            return null;
        }
    }

    public Optional<Profile> findProfileById(Long id) {
        Optional<Profile> profile = profileRepository.findProfileById(id);
        if (profile.isPresent())
            return Optional.of(profile.get());
        else {
            LOGGER.log(Level.WARNING, "Failed to find profile in local DB for id: {}", id);
            return null;
        }
    }

    public Collection<Profile> findAllProfiles() {
        return profileRepository.findAll();
    }

}

