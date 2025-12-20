package com.example.service.Impl;
import com.example.entity.Visitor;
import com.example.repository.VisitorRepository;
import com.example.service.VisitorService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class VisitorServiceImpl implements VisitorService {
    private final VisitorRepository visitorRepository;
    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }
    @Override
    public Visitor createVisitor(Visitor visitor) {
        return visitorRepository.save(visitor);
    }
    @Override
    public Visitor getVisitor(Long id) {
        return visitorRepository.findById(id).orElse(null);
    }
    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
}