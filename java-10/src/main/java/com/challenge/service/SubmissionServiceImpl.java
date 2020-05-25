package com.challenge.service;

import java.math.BigDecimal;
import java.util.List;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceImpl implements SubmissionServiceInterface {

    @Autowired
    SubmissionRepository repository;

    @Override
    public Submission save(Submission submission) {
        return repository.save(submission);
    }

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        return repository.findHigherScoreByChallengeId(challengeId);
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return repository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }
    
}