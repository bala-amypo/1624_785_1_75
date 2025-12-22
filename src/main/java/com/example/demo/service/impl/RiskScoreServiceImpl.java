// package com.example.demo.service.impl;
// import com.example.demo.model.RiskScore;
// import com.example.demo.model.Visitor;
// import com.example.demo.repository.RiskScoreRepository;
// import com.example.demo.repository.VisitorRepository;
// import com.example.demo.service.RiskScoreService;
// import com.example.demo.util.RiskLevelUtils;
// import org.springframework.stereotype.Service;
// import java.time.LocalDateTime;
// import java.util.List;
// @Service
// public class RiskScoreServiceImpl implements RiskScoreService {
//     private final RiskScoreRepository scoreRepository;
//     private final VisitorRepository visitorRepository;
//     public RiskScoreServiceImpl(
//             RiskScoreRepository scoreRepository,
//             VisitorRepository visitorRepository) {
//         this.scoreRepository = scoreRepository;
//         this.visitorRepository = visitorRepository;
//     }
//     @Override
//     public RiskScore evaluateRisk(Long visitorId) {
//         Visitor visitor = visitorRepository.findById(visitorId)
//                 .orElseThrow(() -> new RuntimeException("Visitor not found"));

//         int score = 20;
//         String level = RiskLevelUtils.determineRiskLevel(score);
//         RiskScore riskScore = scoreRepository.findByVisitorId(visitorId);
//         if (riskScore == null) {
//             riskScore = new RiskScore();
//             riskScore.setVisitor(visitor);
//         }
//         riskScore.setTotalScore(score);
//         riskScore.setRiskLevel(level);
//         riskScore.setEvaluatedAt(LocalDateTime.now());
//         return scoreRepository.save(riskScore);
//     }
//     @Override
//     public RiskScore getRiskScoreByVisitor(Long visitorId) {
//         return scoreRepository.findByVisitorId(visitorId);
//     }
//     @Override
//     public List<RiskScore> getAllRiskScores() {
//         return scoreRepository.findAll();
//     }
// }

// 

package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.RiskScore;
import com.example.demo.model.Visitor;
import com.example.demo.repository.RiskScoreRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.RiskScoreService;
import com.example.demo.util.RiskLevelUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RiskScoreServiceImpl implements RiskScoreService {

    private final RiskScoreRepository riskScoreRepository;
    private final VisitorRepository visitorRepository;

    public RiskScoreServiceImpl(RiskScoreRepository riskScoreRepository,
                                VisitorRepository visitorRepository) {
        this.riskScoreRepository = riskScoreRepository;
        this.visitorRepository = visitorRepository;
    }

    @Override
    public RiskScore evaluateRisk(Long visitorId) {

        // ✅ NO Optional used here
        Visitor visitor;
        try {
            visitor = visitorRepository.getById(visitorId);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Visitor not found");
        }

        int totalScore = 30;
        String riskLevel = RiskLevelUtils.determineRiskLevel(totalScore);

        RiskScore riskScore = riskScoreRepository.findByVisitorId(visitorId);

        if (riskScore == null) {
            riskScore = RiskScore.builder()
                    .visitor(visitor)
                    .totalScore(totalScore)
                    .riskLevel(riskLevel)
                    .evaluatedAt(LocalDateTime.now())
                    .build();
        } else {
            riskScore.setTotalScore(totalScore);
            riskScore.setRiskLevel(riskLevel);
            riskScore.setEvaluatedAt(LocalDateTime.now());
        }

        return riskScoreRepository.save(riskScore);
    }

    @Override
    public RiskScore getRiskScoreByVisitor(Long visitorId) {

        RiskScore riskScore = riskScoreRepository.findByVisitorId(visitorId);
        if (riskScore == null) {
            throw new ResourceNotFoundException("RiskScore not found");
        }
        return riskScore;
    }

    @Override
    public List<RiskScore> getAllRiskScores() {
        return riskScoreRepository.findAll();
    }
}
