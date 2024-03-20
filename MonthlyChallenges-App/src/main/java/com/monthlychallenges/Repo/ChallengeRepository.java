package com.monthlychallenges.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monthlychallenges.Model.Challenge;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge , Long>{

     Challenge getChallengeByMonth(String month);
}
