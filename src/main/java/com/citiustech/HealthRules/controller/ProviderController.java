package com.citiustech.HealthRules.controller;

import com.citiustech.HealthRules.model.Provider;
import com.citiustech.HealthRules.service.ProviderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    // CREATE
    @PostMapping
    public Provider create(@RequestBody Provider provider) {
        return providerService.createProvider(provider);
    }

    // READ ALL
    @GetMapping
    public List<Provider> getAll() {
        return providerService.getAllProviders();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Provider getById(@PathVariable Long id) {
        return providerService.getProvider(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Provider update(@PathVariable Long id,
                           @RequestBody Provider provider) {
        return providerService.updateProvider(id, provider);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        providerService.deleteProvider(id);
    }

    // SEARCH
    @GetMapping("/search")
    public List<Provider> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String specialty,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Boolean inNetwork) {

        return providerService.searchProviders(name, specialty, city, inNetwork);
    }
}
