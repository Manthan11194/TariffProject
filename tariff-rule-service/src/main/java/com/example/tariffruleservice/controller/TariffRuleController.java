package com.example.tariffruleservice.controller;

import com.example.tariffruleservice.entity.TariffRule;
import com.example.tariffruleservice.service.TariffRuleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tariff")
public class TariffRuleController {

    private final TariffRuleService service;

    public TariffRuleController(TariffRuleService service) {
        this.service = service;
    }

    @PostMapping
    public TariffRule createRule(@RequestBody TariffRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/{entityId}/{country}/{level}")
    public TariffRule getRules(@PathVariable String entityId, @PathVariable String country, @PathVariable String level) {
        return service.getRules(entityId, country, level);
    }

    @GetMapping
    public List<TariffRule> getAll() {
        return service.getAll();
    }
}
