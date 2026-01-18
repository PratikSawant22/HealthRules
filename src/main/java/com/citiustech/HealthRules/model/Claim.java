package com.citiustech.HealthRules.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String claimNumber;

    private Long memberId;
    private Long providerId;

    private BigDecimal totalCharge;
    private BigDecimal approvedAmount;

    @Enumerated(EnumType.STRING)
    private ClaimStatus status;

    private String denialReason;

    private LocalDate serviceDate;
    private LocalDate submittedDate;

    // getters/setters
}