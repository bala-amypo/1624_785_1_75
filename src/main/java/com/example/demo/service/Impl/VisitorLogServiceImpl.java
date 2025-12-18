package com.example.demo.service;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.model.VisitLog;
import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.exception.ResourceNotFoundException;
@Service
public class VisitLogServiceImpl implements VisitLogService {
    private final VisitLogRepository logRepo;
    private final VisitorRepository visitorRepo;
    public VisitLogServiceImpl(VisitLogRepository logRepo, VisitorRepository visitorRepo) {
        this.logRepo = logRepo;
        this.visitorRepo = visitorRepo;
    }
    public VisitLog createVisitLog(Long visitorId, VisitLog log) {
        Visitor visitor = visitorRepo.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
        log.setVisitor(visitor);
        return logRepo.save(log);
    }
    public VisitLog getLog(Long id) {
        return logRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VisitLog not found"));
    }
    public List<VisitLog> getLogsByVisitor(Long visitorId) {
        return logRepo.findByVisitorId(visitorId);
    }
}