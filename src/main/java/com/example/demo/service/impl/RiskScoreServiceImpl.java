package com.example.service.impl;
import com.example.demo.model.RiskRules;
import com.example.demo.model.RiskScore;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskRulesRepository;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RiskScoreServiceImpl implements RiskScoreService {
    private final RiskScoreRepository riskScoreRepository;
    private final RiskRulesRepository riskRulesRepository;
    private final VisitorRepository visitorRepository;
    public RiskScoreServiceImpl(RiskScoreRepository riskScoreRepository,RiskRulesRepository riskRulesRepository,VisitorRepository visitorRepository) {
        this.riskScoreRepository = riskScoreRepository;
        this.riskRulesRepository = riskRulesRepository;
        this.visitorRepository = visitorRepository;
    }
    @Override
    public RiskScore evaluateVisitor(Long visitorId) {
        Visitor visitor = visitorRepository.findById(visitorId).orElse(null);
        List<RiskRules> rules = riskRuleRepository.findAll();
        int totalScore = 0;
        for (RiskRules rule : rules) {
            totalScore += rule.getScore();
        }
        RiskScore riskScore = new RiskScore();
        riskScore.setVisitor(visitor);
        riskScore.setScore(totalScore);
        return riskScoreRepository.save(riskScore);
    }
    @Override
    public RiskScore getScoreForVisitor(Long visitorId) {
        return riskScoreRepository.findByVisitorId(visitorId);
    }
    @Override
    public List<RiskScore> getAllScores() {
        return riskScoreRepository.findAll();
    }
}