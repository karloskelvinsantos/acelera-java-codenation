package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CandidateController {

    protected CandidateService candidateService;
    protected CandidateMapper candidateMapper;

    public CandidateController(CandidateService candidateService, CandidateMapper candidateMapper) {
        this.candidateService = candidateService;
        this.candidateMapper = candidateMapper;
    }

    @GetMapping(value = "/candidate/{userId}/{accelerationId}/{companyId}")
    public CandidateDTO oneCandidate(@PathVariable Long userId, @PathVariable Long companyId, @PathVariable Long accelerationId) {
        Candidate candidate = candidateService.findById(userId, companyId, accelerationId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidate not found!"));
        return candidateMapper.map(candidate);
    }

    /*@GetMapping(value = "/candidate/{companyId}")
    public List<CandidateDTO> candidatesByCompany(@PathVariable Long companyId) {
        return candidateMapper.map(candidateService.findByCompanyId(companyId));
    }*/

    @GetMapping(value = "/candidate")
    public List<CandidateDTO> candidatesByAcceleration(@RequestParam(name = "companyId") Long companyId) {
        return candidateMapper.map(candidateService.findByCompanyId(companyId));
    }
}
