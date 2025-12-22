// package com.example.demo.repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.RiskRule;
// public interface RiskRuleRepository extends JpaRepository<RiskRule, Long> {
//     RiskRule findByRuleName(String ruleName);
// }

package com.example.demo.repository;
import com.example.demo.model.RiskRule;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RiskRuleRepository extends JpaRepository<RiskRule, Long> {
     boolean existsByRuleName(String ruleName);
}
