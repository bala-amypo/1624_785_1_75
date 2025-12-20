package com.example.demo.service;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.RiskScore;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.exception.ResourceNotFoundException;
@Service
public class RiskScoreServiceImpl implements RiskScoreService {
    private final RiskScoreRepository scoreRepo;
    private final VisitorRepository visitorRepo;
    public RiskScoreServiceImpl(RiskScoreRepository scoreRepo,VisitorRepository visitorRepo) {
        this.scoreRepo = scoreRepo;
        this.visitorRepo = visitorRepo;
    }
    @Override
    public RiskScore evaluateVisitor(Long visitorId, Integer totalScore) {
        Visitor visitor = visitorRepo.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
        RiskScore riskScore = new RiskScore();
        riskScore.setVisitor(visitor);
        riskScore.setTotalScore(totalScore);

        return scoreRepo.save(riskScore);
    }

    // READ by ID
    @Override
    public RiskScore getRiskScore(Long id) {
        return scoreRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RiskScore not found"));
    }

    // READ all
    @Override
    public List<RiskScore> getAllRiskScores() {
        return scoreRepo.findAll();
    }

    // DELETE
    @Override
    public void deleteRiskScore(Long id) {
        RiskScore score = getRiskScore(id);
        scoreRepo.delete(score);
    }
}
