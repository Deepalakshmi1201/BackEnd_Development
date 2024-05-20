package com.jobportal.review;

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
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    };

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReview(@PathVariable Long companyId) {    
        return ResponseEntity.ok(reviewService.getAllReview(companyId));
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@PathVariable Long companyId,@RequestBody Review review){

      boolean created =  reviewService.createReview(companyId, review);
      if(created){
        return  ResponseEntity.ok("Review created");
      }
      return new ResponseEntity<>("review not created", HttpStatus.NOT_FOUND);
        
    }
    
    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,@PathVariable Long id){
        return ResponseEntity.ok(reviewService.getReview(companyId, id));
    }

    @PutMapping("/reviews/{id}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,@RequestBody Review review,@PathVariable Long id){
       
        boolean updated = reviewService.updateReview(companyId, review, id);
        if(updated){
            return ResponseEntity.ok("Review updated");
        }
        return new ResponseEntity<>("updation failed" ,HttpStatus.NOT_FOUND);
        
    }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,@PathVariable Long id){
       
        boolean deleted = reviewService.deleteReview(companyId, id);
        if(deleted){
            return ResponseEntity.ok("Review deleted");
        }
        return new ResponseEntity<>("deletion failed" ,HttpStatus.NOT_FOUND);
        
    }
}
