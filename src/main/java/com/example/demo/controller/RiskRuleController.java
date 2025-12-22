package com.example.demo.controller;
import com.example.demo.model.RiskRule;
import com.example.demo.service.RiskRuleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
