package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.RiskScore;
import java.util.Optional;

public interface RiskScoreRepository extends JpaRepository<RiskScore, Long> {

    /**
     * Retrieve the risk score for a specific visitor
     */
    Optional<RiskScore> findByVisitorId(Long visitorId);
}
