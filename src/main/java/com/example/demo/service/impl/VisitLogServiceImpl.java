package com.example.demo.service.impl;
import com.example.demo.model.VisitLog;
import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitLogRepository;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitLogService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class VisitLogServiceImpl implements VisitLogService {
    private final VisitLogRepository logRepository;
    private final VisitorRepository visitorRepository;

    public VisitLogServiceImpl(
            VisitLogRepository logRepository,
            VisitorRepository visitorRepository) {
        this.logRepository = logRepository;
        this.visitorRepository = visitorRepository;
    }

    @Override
    public VisitLog createVisitLog(Long visitorId, VisitLog visitLog) {
        Visitor visitor = visitorRepository.findById(visitorId)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));

        visitLog.setVisitor(visitor);
        return logRepository.save(visitLog);
    }

    @Override
    public VisitLog getVisitLogById(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("VisitLog not found"));
    }

    @Override
    public List<VisitLog> getLogsByVisitor(Long visitorId) {
        return logRepository.findByVisitorId(visitorId);
    }
}
