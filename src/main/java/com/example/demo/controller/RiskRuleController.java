package com.example.demo.controller;

import com.example.demo.model.RiskRule;
import com.example.demo.service.RiskRuleService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-rules")
@Tag(name = "RiskRule")
public class RiskRuleController {

    private final RiskRuleService service;

    public RiskRuleController(RiskRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RiskRule> create(@RequestBody RiskRule r) {
        return ResponseEntity.ok(service.createRule(r));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskRule> get(@PathVariable long id) {
        return ResponseEntity.ok(service.getRule(id));
    }

    @GetMapping
    public ResponseEntity<List<RiskRule>> all() {
        return ResponseEntity.ok(service.getAllRules());
    }
}



// package com.example.demo.controller;

// import com.example.demo.model.RiskRule;
// import com.example.demo.service.RiskRuleService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.http.ResponseEntity;

// import java.util.List;

// @Tag(name = "RiskRule")
// public class RiskRuleController {

//     private final RiskRuleService service;

//     public RiskRuleController(RiskRuleService service) {
//         this.service = service;
//     }

//     public ResponseEntity<RiskRule> create(RiskRule r) {
//         return ResponseEntity.ok(service.createRule(r));
//     }

//     public ResponseEntity<RiskRule> get(long id) {
//         return ResponseEntity.ok(service.getRule(id));
//     }

//     public ResponseEntity<List<RiskRule>> all() {
//         return ResponseEntity.ok(service.getAllRules());
//     }
// }
