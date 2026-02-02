package com.citiustech.HealthRules.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.citiustech.HealthRules.model.Claim;
import com.citiustech.HealthRules.model.ClaimStatus;
import com.citiustech.HealthRules.repository.ClaimRepository;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;
    private final AdjudicationService adjudicationService;

    public ClaimService(ClaimRepository claimRepository,
                        AdjudicationService adjudicationService) {
        this.claimRepository = claimRepository;
        this.adjudicationService = adjudicationService;
    }

    public Claim submitClaim(Claim claim) {
        claim.setSubmittedDate(LocalDate.now());
        claim.setStatus(ClaimStatus.SUBMITTED);

        Claim adjudicated = adjudicationService.adjudicate(claim);
        return claimRepository.save(adjudicated);
    }

    public List<Claim> getClaims(){
        return claimRepository.findAll();
    }
}
