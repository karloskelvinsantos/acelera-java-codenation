package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CompanyController {

    protected CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(value = "/company/{id}")
    public Company oneCompany(@PathVariable Long id) {
        return companyService.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Company not found!"
        ));
    }

    @GetMapping(value = "/company")
    public List<Company> companiesByAccelerationOrUser(@RequestParam(name = "accelerationId", required = false) Long accelerationId,
                                                 @RequestParam(name = "userId", required = false) Long userId) {

        if (accelerationId != null) {
            return companyService.findByAccelerationId(accelerationId);
        }

        if (userId != null) {
            return companyService.findByUserId(userId);
        }

        return null;
    }
}
