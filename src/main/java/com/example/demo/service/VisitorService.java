package com.example.demo.service;
import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class VisitorService {
    private final VisitorRepository visitorRepository;
    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }
    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }
    public Visitor getVisitor(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
    }
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
}