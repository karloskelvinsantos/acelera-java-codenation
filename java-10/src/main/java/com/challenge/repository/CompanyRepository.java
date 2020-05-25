package com.challenge.repository;

import java.util.List;

import com.challenge.entity.Company;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
    
    @Query("FROM Company company JOIN Candidate c JOIN Acceleration a WHERE a.id = :accelerationId")
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);

    @Query("FROM Company company JOIN Candidate c JOIN User u WHERE u.id = :userId")
	List<Company> findByUserId(@Param("userId") Long userId);
}