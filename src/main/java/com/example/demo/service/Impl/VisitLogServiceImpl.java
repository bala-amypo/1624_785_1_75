package com.example.service.Impl;
import com.example.demo.model.VisitLog;
import com.example.demo.model.Visitor;
import com.example.repository.VisitLogRepository;
import com.example.repository.VisitorRepository;
import com.example.service.VisitLogService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class VisitLogServiceImpl implements VisitLogService {
    private final VisitLogRepository visitLogRepository;
    private final VisitorRepository visitorRepository;
    public VisitLogServiceImpl(VisitLogRepository visitLogRepository,VisitorRepository visitorRepository) {
        this.visitLogRepository = visitLogRepository;
        this.visitorRepository = visitorRepository;
    }
    @Override
    public VisitLog createVisitLog(Long visitorId, VisitLog log) {
        Visitor visitor = visitorRepository.findById(visitorId).orElse(null);
        log.setVisitor(visitor);
        return visitLogRepository.save(log);
    }
   @Override
    public VisitLog getLog(Long id) {
        return visitLogRepository.findById(id).orElse(null);
    }
    @Override
    public List<VisitLog> getLogsByVisitor(Long visitorId) {
        return visitLogRepository.findByVisitorId(visitorId);
    }
}