package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.RiskRule;

public interface RiskRuleRepository extends JpaRepository<RiskRule, Long> {
}
