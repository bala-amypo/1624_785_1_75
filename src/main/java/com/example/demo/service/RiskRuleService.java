package com.example.demo.service;
import java.util.List;
import com.example.demo.model.RiskRule;
public interface RiskRuleService {
    RiskRule createRule(RiskRule rule);
    RiskRule getRule(Long id);
    List<RiskRule> getAllRules();
}