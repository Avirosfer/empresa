package edu.udea.empresaweb.empresa.repositories;

import edu.udea.empresaweb.empresa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);


}
