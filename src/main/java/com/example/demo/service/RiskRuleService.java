package com.example.demo.service;

import com.example.demo.entity.RiskRule;
import java.util.List;

public interface RiskRuleService {

    RiskRule createRiskRule(RiskRule rule);

    RiskRule getRiskRuleById(Long id);

    List<RiskRule> getAllRiskRules();
}
