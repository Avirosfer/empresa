package edu.udea.empresaweb.empresa.services;

import edu.udea.empresaweb.empresa.entities.Profile;
import edu.udea.empresaweb.empresa.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }


    @Override
    public void saveProfile(Profile profile) {
        this.profileRepository.save(profile);
    }

    @Override
    public Profile getProfileById(long id) {
        Optional<Profile> optional = profileRepository.findById(String.valueOf(id));
        Profile profile = null;
        if (optional.isPresent()) {
            profile = optional.get();
        } else {
            throw new RuntimeException(" Profile not found for id :: " + id);
        }
        return profile;
    }

    @Override
    public void deleteProfileById(long id) {
        this.profileRepository.deleteById(String.valueOf(id));
    }

}
