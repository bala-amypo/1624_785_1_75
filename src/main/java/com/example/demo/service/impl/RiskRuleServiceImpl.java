package com.example.demo.service.impl;

import com.example.demo.entity.RiskRule;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.service.RiskRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskRuleServiceImpl implements RiskRuleService {

    private final RiskRuleRepository repository;

    public RiskRuleServiceImpl(RiskRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public RiskRule createRiskRule(RiskRule rule) {
        return repository.save(rule);
    }

    @Override
    public RiskRule getRiskRuleById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("RiskRule not found"));
    }

    @Override
    public List<RiskRule> getAllRiskRules() {
        return repository.findAll();
    }
}
