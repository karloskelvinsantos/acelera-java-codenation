package com.challenge.service;

import java.util.List;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChallengeServiceImpl implements ChallengeServiceInterface {

    private final ChallengeRepository repository;

    @Autowired
    public ChallengeServiceImpl(ChallengeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Challenge save(Challenge challenge) {
        return repository.save(challenge);
    }

    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return repository.findByAccelerationIdAndUserId(accelerationId, userId);
    }
    
}