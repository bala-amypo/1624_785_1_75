package com.example.service.impl;
import com.example.demo.model.RiskRule;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.service.RiskRuleService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RiskRuleServiceImpl implements RiskRuleService {
    private final RiskRuleRepository riskRuleRepository;
    public RiskRuleServiceImpl(RiskRuleRepository riskRuleRepository) {
        this.riskRuleRepository = riskRuleRepository;
    }
    @Override
    public RiskRule createRule(RiskRule rule) {
        return riskRuleRepository.save(rule);
    }
    @Override
    public List<RiskRule> getAllRule() {
        return riskRuleRepository.findAll();
    }
    @Override
    public RiskRule getRule(Long id) {
        return riskRuleRepository.findById(id).orElse(null);
    }
}