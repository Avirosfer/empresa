package edu.udea.empresaweb.empresa.services;


import edu.udea.empresaweb.empresa.entities.Enterprise;
import edu.udea.empresaweb.empresa.repositories.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseServicesImpl implements EnterpriseService {
    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Override
    public List<Enterprise> getAllEnterprises() {
        return enterpriseRepository.findAll();
    }

    @Override
    public void saveEnterprise(Enterprise enterprise) {
        this.enterpriseRepository.save(enterprise);
    }

    @Override
    public Enterprise getEnterpriseById(long id) {
        Optional<Enterprise> optional = enterpriseRepository.findById(id);
        Enterprise enterprise = null;
        if (optional.isPresent()) {
            enterprise = optional.get();
        } else {
            throw new RuntimeException(" Enterprise not found for id :: " + id);
        }
        return enterprise;
    }

    @Override
    public void deleteEnterpriseById(long id) {
        this.enterpriseRepository.deleteById(id);
    }


}
