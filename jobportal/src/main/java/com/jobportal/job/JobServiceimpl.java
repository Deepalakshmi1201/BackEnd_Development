package com.jobportal.job;


import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JobServiceimpl implements Jobservice {

    private JobRepo jobRepo;
    public JobServiceimpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }
    

    @Override
    public void createJob(Job job) {
        jobRepo.save(job);
    }

   

 @Override
    public List<Job> findAll() {
        return jobRepo.findAll();
    }

    @Override
    public boolean deleteJob(Long id) {
       if(jobRepo.existsById(id)) {
        jobRepo.deleteById(id);
        return true;
       }
       return false; 
        
    }

    @Override
    public Job getJob(Long id) {
            return jobRepo.findById(id).orElse(null);

    }

    @Override
    public boolean updateJob(Long id,Job updatedJob) {
       
            if(jobRepo.existsById(id)){
                jobRepo.save(updatedJob);
                return true;  
            }
        return false;
        
    }


    
}
