package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class AccelerationController {

    protected final AccelerationService accelerationService;

    public AccelerationController(AccelerationService accelerationService) {
        this.accelerationService = accelerationService;
    }

    @GetMapping(value = "/acceleration/{id}")
    public Acceleration oneAcceleration(@PathVariable Long id) {
        return accelerationService.findById(id).orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Acceleration not found!"
        ));
    }

    @GetMapping(value = "/acceleration")
    public List<Acceleration> getAccelerationByCompany(@RequestParam(name = "companyId") Long companyId) {
        return accelerationService.findByCompanyId(companyId);
    }
}
