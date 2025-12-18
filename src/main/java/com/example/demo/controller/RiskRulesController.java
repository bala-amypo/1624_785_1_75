package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk-rules")
public class RiskRuleController {

    @PostMapping
    public ResponseEntity<String> createRule(@RequestBody Object rule) {
        return ResponseEntity.ok("Risk rule created");
    }

    @GetMapping
    public ResponseEntity<String> listRules() {
        return ResponseEntity.ok("List of risk rules");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getRule(@PathVariable Long id) {
        return ResponseEntity.ok("Risk rule with id: " + id);
    }
}