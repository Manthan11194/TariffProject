package com.example.tariffruleservice.service;

import com.example.tariffruleservice.entity.TariffRule;
import com.example.tariffruleservice.repository.TariffRuleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TariffRuleService {

    private final TariffRuleRepository repository;

    public TariffRuleService(TariffRuleRepository repository) {
        this.repository = repository;
    }

    public TariffRule createRule(TariffRule rule) {
        return repository.save(rule);
    }

    public TariffRule getRules(String entityId, String country, String level) {
        return repository.findByEntityIdAndCountryAndLevel(entityId, country, level).get();
    }

    public List<TariffRule> getAll() {
        return repository.findAll();
    }
}
