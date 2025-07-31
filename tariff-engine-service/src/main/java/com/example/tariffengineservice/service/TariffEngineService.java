package com.example.tariffengineservice.service;


import com.example.tariffengineservice.dtos.TariffCalculationResponse;
import com.example.tariffengineservice.entity.TariffRule;
import com.example.tariffengineservice.repository.TariffRuleRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class TariffEngineService {

    private final TariffRuleRepository tariffRuleRepository;
    private final RestTemplate restTemplate;

    @Value("${bom.resolver.url}")
    private String bomResolverUrl;

    public TariffEngineService(TariffRuleRepository tariffRuleRepository, RestTemplate restTemplate) {
        this.tariffRuleRepository = tariffRuleRepository;
        this.restTemplate = restTemplate;
    }

    public TariffCalculationResponse computeTariff(String itemId, String country) {

        Map itemResponse = restTemplate.getForObject(bomResolverUrl + itemId, Map.class);
        List<Map<String, Object>> components = (List<Map<String, Object>>) itemResponse.get("components");

        double itemTariff = tariffRuleRepository
                .findByLevelAndEntityIdAndCountry("item", itemId, country)
                .stream()
                .mapToDouble(TariffRule::getTariffRate)
                .sum();

        List<String> componentIds = new ArrayList<>();
        for (Map<String, Object> comp : components) {
            componentIds.add((String) comp.get("componentId"));
        }

        Map<String, Double> componentBreakdown = new HashMap<>();
        double componentTariff = 0.0;

        List<TariffRule> componentRules = tariffRuleRepository.findByLevelAndEntityIdInAndCountry("component", componentIds, country);
        for (TariffRule rule : componentRules) {
            componentBreakdown.put(rule.getEntityId(), rule.getTariffRate());
            componentTariff += rule.getTariffRate();
        }

        double totalTariff = itemTariff + componentTariff;

        return new TariffCalculationResponse(itemId, country, itemTariff, componentTariff, totalTariff, componentBreakdown);
    }
}
