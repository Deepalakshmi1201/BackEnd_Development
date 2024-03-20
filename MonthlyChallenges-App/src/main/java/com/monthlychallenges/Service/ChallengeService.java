package com.monthlychallenges.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.monthlychallenges.Model.Challenge;
import com.monthlychallenges.Repo.ChallengeRepository;

@Service
public class ChallengeService {

private ChallengeRepository challengeRepository;

     public ChallengeService(ChallengeRepository challengeRepository) {
    this.challengeRepository = challengeRepository;
}

    public Boolean AddChallenges( Challenge challenge){
        if(challenge != null){
            challengeRepository.save(challenge);
            return true;
        }
        else{
            return false;
        }
    }

    public List<Challenge> GetAllChallenges(){
        return challengeRepository.findAll();
    }

    public Challenge GetchallengesByid(String month){

        return challengeRepository.getChallengeByMonth(month);
    }

   
    public boolean UpdateChallenge(Long id, Challenge updatedChallenge){
        if(challengeRepository.existsById(id)){
            challengeRepository.save(updatedChallenge);
            return true;
        }
        return false;
         
    }

    public boolean DeleteChallenge(Long id) {   
        if(challengeRepository.existsById(id)){
            challengeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
