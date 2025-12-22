// 
package com.example.demo.service.impl;

import com.example.demo.entity.RiskRule;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.service.RiskRuleService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RiskRuleServiceImpl implements RiskRuleService {

    private final RiskRuleRepository riskRuleRepository;

    public RiskRuleServiceImpl(RiskRuleRepository riskRuleRepository) {
        this.riskRuleRepository = riskRuleRepository;
    }

    @Override
    public RiskRule createRiskRule(RiskRule rule) {

        if (rule.getThreshold() < 0 || rule.getScoreImpact() < 0) {
            throw new BadRequestException("Threshold and scoreImpact must be non-negative");
        }

        if (riskRuleRepository.existsByRuleName(rule.getRuleName())) {
            throw new BadRequestException("Rule name must be unique");
        }

        return riskRuleRepository.save(rule);
    }

    @Override
    public RiskRule getRiskRuleById(Long id) {
        return riskRuleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Risk rule not found"));
    }

    @Override
    public List<RiskRule> getAllRiskRules() {
        return riskRuleRepository.findAll();
    }
}
