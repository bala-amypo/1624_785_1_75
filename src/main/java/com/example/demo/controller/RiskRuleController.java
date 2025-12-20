package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RiskRule;
import com.example.demo.exception.BadRequestException;
import com.example.demo.service.RiskRuleService;

@RestController
@RequestMapping("/api/risk-rules")
public class RiskRuleController {

    private final RiskRuleService riskRuleService;

    // ✅ Constructor injection for test compatibility
    public RiskRuleController(RiskRuleService riskRuleService) {
        this.riskRuleService = riskRuleService;
    }

    // POST /api/risk-rules
    @PostMapping
    public ResponseEntity<?> createRule(@RequestBody RiskRule rule) {
        try {
            RiskRule created = riskRuleService.createRule(rule);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (BadRequestException e) {
            // Tests expect "Rule name must be unique" for duplicates
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // GET /api/risk-rules/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getRule(@PathVariable Long id) {
        try {
            RiskRule rule = riskRuleService.getRule(id);
            return ResponseEntity.ok(rule);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // GET /api/risk-rules
    @GetMapping
    public ResponseEntity<List<RiskRule>> getAllRules() {
        List<RiskRule> rules = riskRuleService.getAllRules();
        return ResponseEntity.ok(rules); // empty list handled by service
    }
}
