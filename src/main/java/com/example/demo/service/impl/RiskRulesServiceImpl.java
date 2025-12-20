package com.example.service.impl;
import com.example.demo.model.RiskRules;
import com.example.repository.RiskRulesRepository;
import com.example.service.RiskRulesService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RiskRulesServiceImpl implements RiskRulesService {
    private final RiskRulesRepository riskRulesRepository;
    public RiskRulesServiceImpl(RiskRulesRepository riskRulesRepository) {
        this.riskRulesRepository = riskRulesRepository;
    }
    @Override
    public RiskRules createRule(RiskRules rule) {
        return riskRulesRepository.save(rule);
    }
    @Override
    public List<RiskRules> getAllRules() {
        return riskRulesRepository.findAll();
    }
    @Override
    public RiskRules getRule(Long id) {
        return riskRulesRepository.findById(id).orElse(null);
    }
}