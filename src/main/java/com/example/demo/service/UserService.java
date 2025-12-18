package com.example.demo.service;
import com.example.demo.model.ScoreAuditLog;
import com.example.demo.repository.ScoreAuditLogRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ScoreAuditLogService {

    private ScoreAuditLogRepository repo;

    public ScoreAuditLogService(ScoreAuditLogRepository repo) {
        this.repo = repo;
    }

    public ScoreAuditLog saveLog(ScoreAuditLog log) {
        return repo.save(log);
    }

    public ScoreAuditLog getLog(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<ScoreAuditLog> getLogsByVisitor(Long visitorId) {
        return repo.findByVisitorId(visitorId);
    }
}