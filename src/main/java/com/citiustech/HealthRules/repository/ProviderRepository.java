package com.citiustech.HealthRules.repository;

import com.citiustech.HealthRules.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    List<Provider> findByProviderNameContainingIgnoreCase(String name);

    List<Provider> findBySpecialtyIgnoreCase(String specialty);

    List<Provider> findByCityIgnoreCase(String city);

    @Query("""
       SELECT p FROM Provider p
       WHERE (:name IS NULL OR LOWER(p.providerName) LIKE LOWER(CONCAT('%', :name, '%')))
       AND (:specialty IS NULL OR LOWER(p.specialty) = LOWER(:specialty))
       AND (:city IS NULL OR LOWER(p.city) = LOWER(:city))
       AND (:inNetwork IS NULL OR p.inNetwork = :inNetwork)
    """)
    List<Provider> searchProviders(
            @Param("name") String name,
            @Param("specialty") String specialty,
            @Param("city") String city,
            @Param("inNetwork") Boolean inNetwork
    );
}

