package edu.udea.empresaweb.empresa.repositories;

import edu.udea.empresaweb.empresa.entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {


}
