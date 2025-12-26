package com.example.demo.repository;

import com.example.demo.model.ScoreAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreAuditLogRepository extends JpaRepository<ScoreAuditLog, Long> {
}



// package com.example.demo.repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.ScoreAuditLog;
// import java.util.List;
// public interface ScoreAuditLogRepository extends JpaRepository<ScoreAuditLog, Long> {
//      List<ScoreAuditLog> findByVisitorId(Long visitorId);
// }
