package com.jobportal.job;


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
@RequestMapping("/jobs")
public class JobController {
 
    private Jobservice jobservice;
    public JobController(Jobservice jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping()
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobservice.findAll(),HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobservice.createJob(job);
        return new ResponseEntity<>("Job created",HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id ){
        Job job = jobservice.getJob(id);
        if(job != null){
            return  ResponseEntity.ok(job); 
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id ){
        Boolean deleted = jobservice.deleteJob(id);
        if(deleted){
            return  ResponseEntity.ok("SucessFully Deleted"); 
        }
        return  new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED); 
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id , @RequestBody Job updatedJob){
        Boolean updated = jobservice.updateJob(id, updatedJob);
        if(updated){
            return  ResponseEntity.ok("SucessFully upated"); 
        }
        return  new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED); 
        
    }
}
