package com.citiustech.HealthRules.service;

import com.citiustech.HealthRules.model.Provider;
import com.citiustech.HealthRules.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public Provider createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public Provider updateProvider(Long id, Provider updated) {
        Provider existing = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        existing.setProviderName(updated.getProviderName());
        existing.setSpecialty(updated.getSpecialty());
        existing.setCity(updated.getCity());
        existing.setState(updated.getState());
        existing.setInNetwork(updated.isInNetwork());
        existing.setNpi(updated.getNpi());

        return providerRepository.save(existing);
    }

    public Provider getProvider(Long id) {
        return providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));
    }

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public void deleteProvider(Long id) {
        providerRepository.deleteById(id);
    }

    public List<Provider> searchProviders(
            String name, String specialty, String city, Boolean inNetwork) {

        return providerRepository.searchProviders(name, specialty, city, inNetwork);
    }
}
