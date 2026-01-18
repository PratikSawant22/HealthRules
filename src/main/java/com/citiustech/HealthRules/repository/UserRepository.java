package com.citiustech.HealthRules.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.HealthRules.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
