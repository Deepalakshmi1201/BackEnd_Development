package com.jobportal.company;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping()
    public ResponseEntity<List<Company>> getAllCompany(){
        return new ResponseEntity<>(companyService.getAllCompany(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Created",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id ,@RequestBody Company updatedCompany){
       Boolean updated =  companyService.updateCompany(id, updatedCompany);
       if(updated){
        return ResponseEntity.ok("Company updated");
       }
       return new ResponseEntity<>("updation failed ",HttpStatus.NOT_FOUND); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
       Boolean deleted=  companyService.deleteCompany(id);
       if(deleted){
        return ResponseEntity.ok("Company Deleted");
       }
       return new ResponseEntity<>("updation Deleted ",HttpStatus.NOT_FOUND); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id){
        return new ResponseEntity<>(companyService.getCompany(id),HttpStatus.OK);
    }




}
