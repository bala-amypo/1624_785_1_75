package com.example.demo.controller;

import com.example.demo.entity.RiskRule;
import com.example.demo.service.RiskRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-rules")
public class RiskRuleController {

    private final RiskRuleService service;

    public RiskRuleController(RiskRuleService service) {
        this.service = service;
    }

    @PostMapping
    public RiskRule createRule(@RequestBody RiskRule rule) {
        return service.createRiskRule(rule);
    }

    @GetMapping("/{id}")
    public RiskRule getRule(@PathVariable Long id) {
        return service.getRiskRuleById(id);
    }

    @GetMapping
    public List<RiskRule> getAllRules() {
        return service.getAllRiskRules();
    }
}
