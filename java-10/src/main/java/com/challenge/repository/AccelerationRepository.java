package com.challenge.repository;

import java.util.List;

import com.challenge.entity.Acceleration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

  @Query("FROM Acceleration a JOIN a.candidates candidate WHERE candidate.id.company.id = :companyId")
	List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);

    
}