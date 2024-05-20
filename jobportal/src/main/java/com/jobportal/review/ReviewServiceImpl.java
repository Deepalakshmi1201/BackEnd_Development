package com.jobportal.review;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobportal.company.Company;
import com.jobportal.company.CompanyService;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepo reviewRepo;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepo reviewRepo, CompanyService companyService) {
        this.reviewRepo = reviewRepo;
        this.companyService = companyService;
    }


    @Override
    public List<Review> getAllReview(Long companyId) {    
        List<Review> reviews =  reviewRepo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        
        Company company = companyService.getCompany(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepo.save(review);
            return true;
        }
        return false;
        
    }


    @Override
    public boolean updateReview(Long companyId, Review updatedReview, Long id) {
        
        Company company = companyService.getCompany(companyId);
        if(company != null){
            updatedReview.setCompany(company);
            reviewRepo.save(updatedReview);
            return true;
        }
        return false;
    }


    @Override
    public Review getReview(Long companyId, Long id) {
         
        List<Review > reviews = reviewRepo.findByCompanyId(companyId);
        return reviews.stream()
        .filter(review -> review.getId().equals(id))
        .findFirst()
        .orElse(null);

    }


    @Override
    public boolean deleteReview(Long companyId, Long id) {
        
        Company company = companyService.getCompany(companyId);
        if(company != null){
            reviewRepo.deleteById(id);
            return true;
        }
        return false;
    }

    
    
    
}
