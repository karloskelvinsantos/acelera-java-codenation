package com.challenge.service;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccelerationServiceImpl implements AccelerationServiceInterface {

    private final AccelerationRepository repository;

    @Autowired
    public AccelerationServiceImpl(AccelerationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Acceleration save(Acceleration acceleration) {
        return repository.save(acceleration);
    }

    @Override
    public Optional<Acceleration> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return repository.findByCompanyId(companyId);
    }
    
}