package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.RiskScore;

public interface RiskScoreRepository extends JpaRepository<RiskScore, Long> {

    RiskScore findByVisitorId(Long visitorId);
}
