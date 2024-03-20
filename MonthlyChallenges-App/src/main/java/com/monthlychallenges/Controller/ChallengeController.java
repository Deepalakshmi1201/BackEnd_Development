package com.monthlychallenges.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monthlychallenges.Model.Challenge;
import com.monthlychallenges.Service.ChallengeService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/challenges")
public class ChallengeController {


    private ChallengeService challengeService;
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }


    @GetMapping()
    public ResponseEntity<List<Challenge>> GetAllChallenges(){
        return new ResponseEntity<>(challengeService.GetAllChallenges(),HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Challenge>AddChallenges(@RequestBody Challenge challenge){
        
       boolean isChallengeAdded = challengeService.AddChallenges(challenge);

       if(isChallengeAdded){
        return new ResponseEntity<>(HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> GetChallengesBymonth( @PathVariable String month){
        Challenge challenge = challengeService.GetchallengesByid(month);

        if (challenge != null){
            return new ResponseEntity<>(challenge,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

   
   
    @PutMapping("/{id}")
    public ResponseEntity<String> UpdateChallenge(@PathVariable Long id , @RequestBody Challenge updatedChallenge){
        boolean isChallengeUpated = challengeService.UpdateChallenge(id, updatedChallenge);

        if(isChallengeUpated){
            return new ResponseEntity<>("Updates Sucessfully",HttpStatus.OK);
           }
           return new ResponseEntity<>("updation failed",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteChallenge(@PathVariable Long id ){
        boolean isChallengeUpated = challengeService.DeleteChallenge(id);

        if(isChallengeUpated){
            return new ResponseEntity<>("Deleted Sucessfully",HttpStatus.OK);
           }
           return new ResponseEntity<>("Deletion failed",HttpStatus.NOT_FOUND);
    }
    
}
