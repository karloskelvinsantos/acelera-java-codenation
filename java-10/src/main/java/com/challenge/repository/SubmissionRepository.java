package com.challenge.repository;

import java.math.BigDecimal;
import java.util.List;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

    @Query("SELECT max(s.score) FROM Submission s JOIN Challenge c WHERE c.id = :challengeId")
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId")  Long challengId);

    @Query("FROM Submission s JOIN Challenge c JOIN Acceleration a WHERE c.id = :challengeId AND a.id = :accelerationId")
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);   
}