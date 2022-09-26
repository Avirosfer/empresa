package edu.udea.empresaweb.empresa.services;


import edu.udea.empresaweb.empresa.entities.Enterprise;
import java.util.List;

public interface EnterpriseService {
    List<Enterprise> getAllEnterprises();
    void saveEnterprise(Enterprise enterprise);
    Enterprise getEnterpriseById(long id);
    void deleteEnterpriseById(long id);
}
