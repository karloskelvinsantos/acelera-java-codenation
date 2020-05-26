package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {
    
    @Query("FROM Candidate candidate WHERE candidate.id.company.id = :companyId")
    List<Candidate> findByCompanyId(@Param("companyId") Long companyId);

    @Query("FROM Candidate candidate WHERE candidate.id.acceleration.id = :accelerationId")
    List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);

    @Query("FROM Candidate candidate WHERE candidate.id.user.id = :userId AND candidate.id.company.id = :companyId AND candidate.id.acceleration.id = :accelerationId")
    Optional<Candidate> findByUserAndCompanyAndAccelerationId(@Param("userId") Long userId,
                                                          @Param("companyId") Long companyId,
                                                          @Param("companyId") Long accelerationId);
}