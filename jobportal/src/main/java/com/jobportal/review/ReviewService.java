package com.jobportal.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReview(Long companyId);
    boolean createReview(Long companyId , Review review);
    boolean updateReview(Long companyId , Review review, Long id);
    Review getReview(Long companyId , Long id);
    boolean deleteReview(Long companyId , Long id);

    
}
