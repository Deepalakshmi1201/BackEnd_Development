package com.jobportal.company;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class CompanyServiceimpl implements CompanyService{

    private CompanyRepo companyRepo;
    public CompanyServiceimpl(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }


    @Override
    public List<Company> getAllCompany() {
        return companyRepo.findAll() ;
    }


    @Override
    public void createCompany(Company company) {
        companyRepo.save(company);
        
    }


    @Override
    public boolean updateCompany(Long id, Company updatedCompany) {
        if(companyRepo.existsById(id)){
            companyRepo.save(updatedCompany);
            return true;
        }
        return false;
    }


    @Override
    public boolean deleteCompany(Long id) {
        if(companyRepo.existsById(id)){
            companyRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company getCompany(Long id) {
       return companyRepo.findById(id).orElse(null);
    }

    
    

}
