package com.citiustech.HealthRules.dto;

import java.math.BigDecimal;

import com.citiustech.HealthRules.model.ClaimStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClaimResponseDTO {

    private String claimNumber;
    private ClaimStatus status;
    private BigDecimal approvedAmount;
    private String message;
}
