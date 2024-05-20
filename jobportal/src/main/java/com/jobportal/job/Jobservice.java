package com.jobportal.job;

import java.util.List;

public interface Jobservice {
    
    List<Job> findAll();
    void createJob(Job job);
    Job getJob(Long id);
    boolean updateJob(Long id,Job updatedJob);
    boolean deleteJob(Long id);
    
}
