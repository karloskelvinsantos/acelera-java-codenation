package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/challenge")
public class ChallangeController {

    protected final ChallengeService challengeService;

    public ChallangeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public List<Challenge> challengesByIdAndUserId(@RequestParam(name = "accelerationId") Long accelerationId,
                                                   @RequestParam(name = "userId") Long userId) {
        return challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
    }
}
