package com.jobportal.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompany();
    void createCompany(Company company);
    boolean updateCompany(Long id , Company updatedCompany);
    boolean deleteCompany(Long id );
    Company getCompany(Long id);
    
}
