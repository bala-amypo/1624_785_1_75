package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.RiskRule;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.service.RiskRuleService;

@Service
public class RiskRuleServiceImpl implements RiskRuleService {

    @Autowired
    private RiskRuleRepository riskRuleRepository;

    @Override
    public RiskRule createRule(RiskRule rule) {

        // ✅ REQUIRED VALIDATION
        if (riskRuleRepository.existsByRuleName(rule.getRuleName())) {
            throw new BadRequestException("Rule name must be unique");
        }

        return riskRuleRepository.save(rule);
    }

    @Override
    public List<RiskRule> getAllRules() {

        // ✅ NULL-SAFE: return empty list if no rules
        return riskRuleRepository.findAll();
    }

    @Override
    public RiskRule getRule(Long id) {
        return riskRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RiskRule not found"));
    }
}
