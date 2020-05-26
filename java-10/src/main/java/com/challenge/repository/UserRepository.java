package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("FROM User u JOIN u.candidates candidate WHERE candidate.id.acceleration.name = :accelerationName")
    List<User> findByAccelerationName(@Param("accelerationName") String accelerationName);
    
    @Query("FROM User u JOIN u.candidates candidate WHERE candidate.id.company.id = :companyId ")
    List<User> findByCompanyId(@Param("companyId") Long companyId);
}