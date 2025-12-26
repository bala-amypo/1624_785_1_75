package com.example.demo.controller;

import com.example.demo.model.RiskRule;
import com.example.demo.service.RiskRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/risk-rules")
@Tag(name = "Risk Rules")
public class RiskRuleController {
    
    private final RiskRuleService riskRuleService;
    
    public RiskRuleController(RiskRuleService riskRuleService) {
        this.riskRuleService = riskRuleService;
    }
    
    @PostMapping
    public ResponseEntity<RiskRule> create(@RequestBody RiskRule rule) {
        return ResponseEntity.ok(riskRuleService.createRule(rule));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RiskRule> get(@PathVariable Long id) {
        return ResponseEntity.ok(riskRuleService.getRule(id));
    }
    
    @GetMapping
    public ResponseEntity<List<RiskRule>> all() {
        return ResponseEntity.ok(riskRuleService.getAllRules());
    }
}


















// package com.example.demo.controller;
// import com.example.demo.model.RiskRule;
// import com.example.demo.service.RiskRuleService;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import java.util.List;
// @RestController
// @RequestMapping("/api/risk-rules")
// public class RiskRuleController {
//  private final RiskRuleService service;
//     public RiskRuleController(RiskRuleService service) {
//         this.service = service;
//     }
//     @PostMapping
//     public RiskRule createRule(@RequestBody RiskRule rule) {
//         return service.createRiskRule(rule);
//     }
//     @GetMapping("/{id}")
//     public RiskRule getRule(@PathVariable Long id) {
//         return service.getRiskRuleById(id);
//     }
//     @GetMapping
//     public List<RiskRule> getAllRules() {
//         return service.getAllRiskRules();
//     }
// }
