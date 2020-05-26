package com.challenge.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

    @Query("SELECT max(s.score) FROM Submission s JOIN s.id.challenge c WHERE c.id = :challengeId")
    Optional<BigDecimal> findHigherScoreByChallengeId(@Param("challengeId")  Long challengeId);

    @Query("FROM Submission s JOIN s.id.challenge c JOIN c.accelerations ac WHERE c.id = :challengeId AND ac.id = :accelerationId")
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);

}