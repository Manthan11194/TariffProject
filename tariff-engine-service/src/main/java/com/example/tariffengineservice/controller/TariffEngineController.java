package com.example.tariffengineservice.controller;


import com.example.tariffengineservice.dtos.TariffCalculationResponse;
import com.example.tariffengineservice.entity.TariffRule;
import com.example.tariffengineservice.repository.TariffRuleRepository;
import com.example.tariffengineservice.service.TariffEngineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tariff")
public class TariffEngineController {

    private final TariffRuleRepository tariffRuleRepository;
    private final TariffEngineService tariffEngineService;

    public TariffEngineController(TariffRuleRepository tariffRuleRepository, TariffEngineService tariffEngineService) {
        this.tariffRuleRepository = tariffRuleRepository;
        this.tariffEngineService = tariffEngineService;
    }

    @PostMapping("/rules")
    public TariffRule createRule(@RequestBody TariffRule rule) {
        return tariffRuleRepository.save(rule);
    }

    @GetMapping("/rules")
    public List<TariffRule> getAllRules() {
        return tariffRuleRepository.findAll();
    }

    @GetMapping("/rules/{id}")
    public TariffRule getRule(@PathVariable Long id) {
        return tariffRuleRepository.findById(id).get();
    }

    @DeleteMapping("/rules/{id}")
    public void deleteRule(@PathVariable Long id) {
        tariffRuleRepository.deleteById(id);
    }

    @GetMapping("/calculate")
    public ResponseEntity<TariffCalculationResponse> calculateTariff(
            @RequestParam String itemId,
            @RequestParam String country) {
        System.out.println("hello");
        return ResponseEntity.ok(tariffEngineService.computeTariff(itemId, country));
    }
}
