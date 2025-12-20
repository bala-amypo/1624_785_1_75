package com.example.demo.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/api/risk-rules")
public class RiskRulesController {
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