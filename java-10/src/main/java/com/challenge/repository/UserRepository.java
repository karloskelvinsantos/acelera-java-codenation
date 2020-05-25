package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findById(Long id);

    @Query("FROM User u JOIN Candidate JOIN Acceleration ac WHERE ac.name = :accelerationName")
    List<User> findByAccelerationName(@Param("accelerationName") String accelerationName);
    
    @Query("FROM User u JOIN Candidate JOIN Company company WHERE company.id = :companyId ")
    List<User> findByCompanyId(@Param("companyId") Long companyId);
}