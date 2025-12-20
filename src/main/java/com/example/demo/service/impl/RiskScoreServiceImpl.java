package com.example.service.impl;
import com.example.demo.model.RiskRule;
import com.example.demo.model.RiskScore;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskRuleRepository;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RiskScoreServiceImpl implements RiskScoreService {
    private final RiskScoreRepository riskScoreRepository;
    private final RiskRuleRepository riskRuleRepository;
    private final VisitorRepository visitorRepository;
    public RiskScoreServiceImpl(RiskScoreRepository riskScoreRepository,RiskRuleRepository riskRuleRepository,VisitorRepository visitorRepository) {
        this.riskScoreRepository = riskScoreRepository;
        this.riskRuleRepository = riskRuleRepository;
        this.visitorRepository = visitorRepository;
    }
    @Override
    public RiskScore evaluateVisitor(Long visitorId) {
        Visitor visitor = visitorRepository.findById(visitorId).orElse(null);
        List<RiskRule> rules = riskRuleRepository.findAll();
        int totalScore = 0;
        for (RiskRule rule : rules) {
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