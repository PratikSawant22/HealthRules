package com.citiustech.HealthRules.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;

import lombok.Data;

@Data
public class ClaimRequestDTO {

    @NotNull
    private Long memberId;

    @NotNull
    private Long providerId;

    @NotNull
    private BigDecimal totalCharge;

    @NotNull
    private LocalDate serviceDate;
}