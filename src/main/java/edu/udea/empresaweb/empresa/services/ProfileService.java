package edu.udea.empresaweb.empresa.services;

import edu.udea.empresaweb.empresa.entities.Profile;
import java.util.List;


public interface ProfileService {

    List<Profile> getAllProfiles();
    void saveProfile(Profile profile);
    Profile getProfileById(long id);
    void deleteProfileById(long id);

}
