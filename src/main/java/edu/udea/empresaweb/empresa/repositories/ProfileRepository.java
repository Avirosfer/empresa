package edu.udea.empresaweb.empresa.repositories;


import edu.udea.empresaweb.empresa.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {
}
