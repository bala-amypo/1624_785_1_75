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
    public RiskScoreServiceImpl(RiskScoreRepository scoreRepo, VisitorRepository visitorRepo) {
        this.scoreRepo = scoreRepo;
        this.visitorRepo = visitorRepo;
    }
     public RiskScore evaluateVisitor(Long visitorId) {
        Visitor visitor = visitorRepo.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));