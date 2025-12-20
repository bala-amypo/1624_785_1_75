package com.example.demo.service;
import java.util.List;
import com.example.demo.model.RiskRules;
public interface RiskRulesService {
    RiskRules createRule(RiskRules rule);
    RiskRules getRule(Long id);
    List<RiskRules> getAllRules();
}