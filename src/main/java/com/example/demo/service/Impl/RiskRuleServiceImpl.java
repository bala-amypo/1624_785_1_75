package com.example.demo.service;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.RiskRule;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.exception.ResourceNotFoundException;
@Service
public class RiskRuleServiceImpl implements RiskRuleService {
    private final RiskRuleRepository repo;
    public RiskRuleServiceImpl(RiskRuleRepository repo) {
        this.repo = repo;
    }
    public RiskRule createRule(RiskRule rule) {
        return repo.save(rule);
    }
    public RiskRule getRule(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RiskRule not found"));
    }
    public List<RiskRule> getAllRules() {
        return repo.findAll();
    }
}