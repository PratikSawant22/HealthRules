package com.citiustech.HealthRules.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.citiustech.HealthRules.model.Claim;
import com.citiustech.HealthRules.model.ClaimStatus;

@Service
public class AdjudicationService {

    public Claim adjudicate(Claim claim) {

        // Rule 1: Charge limit
        if (claim.getTotalCharge().compareTo(BigDecimal.valueOf(10000)) > 0) {
            claim.setStatus(ClaimStatus.DENIED);
            claim.setDenialReason("Charge exceeds coverage limit");
            return claim;
        }

        // Rule 2: Simple pricing (80% covered)
        BigDecimal approvedAmount = claim.getTotalCharge()
                .multiply(BigDecimal.valueOf(0.8));

        claim.setApprovedAmount(approvedAmount);
        claim.setStatus(ClaimStatus.APPROVED);

        return claim;
    }
}
