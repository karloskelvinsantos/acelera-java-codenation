package com.challenge.repository;

import java.util.List;

import com.challenge.entity.Challenge;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends CrudRepository<Challenge, Long>{

    @Query("FROM Challenge c JOIN c.accelerations a JOIN a.candidates can JOIN can.id.user u WHERE a.id = :accelerationId AND u.id = :userId")
	List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId")  Long accelerationId, @Param("userId") Long userId);
    
}