package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubmissionController {

    protected SubmissionService submissionService;
    protected SubmissionMapper submissionMapper;

    public SubmissionController(SubmissionService submissionService, SubmissionMapper submissionMapper) {
        this.submissionService = submissionService;
        this.submissionMapper = submissionMapper;
    }

    @GetMapping(value = "/submission")
    public List<SubmissionDTO> submissionsByChallengeAndAcceleration(@RequestParam Long challengeId, @RequestParam Long accelerationId) {
        return submissionMapper.map(submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
    }
}
