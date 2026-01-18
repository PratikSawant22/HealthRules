package com.citiustech.HealthRules.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.HealthRules.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long>{

}
