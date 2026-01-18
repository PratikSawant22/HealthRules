package com.citiustech.HealthRules.controller;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.HealthRules.dto.ClaimRequestDTO;
import com.citiustech.HealthRules.dto.ClaimResponseDTO;
import com.citiustech.HealthRules.model.Claim;
import com.citiustech.HealthRules.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    public ClaimResponseDTO submitClaim(@RequestBody @Validated ClaimRequestDTO request) {

        Claim claim = new Claim();
        claim.setMemberId(request.getMemberId());
        claim.setProviderId(request.getProviderId());
        claim.setTotalCharge(request.getTotalCharge());
        claim.setServiceDate(request.getServiceDate());
        claim.setClaimNumber(UUID.randomUUID().toString());

        Claim saved = claimService.submitClaim(claim);

        return new ClaimResponseDTO(
                saved.getClaimNumber(),
                saved.getStatus(),
                saved.getApprovedAmount(),
                saved.getDenialReason()
        );
    }
}
