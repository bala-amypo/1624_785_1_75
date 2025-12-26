package com.example.demo.service.impl;

import com.example.demo.model.Visitor;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;
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
        if (visitor.getPhone() == null) {
            throw new IllegalArgumentException("phone required");
        }
        return visitorRepository.save(visitor);
    }
    
    @Override
    public Visitor getVisitor(Long id) {
        return visitorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("not found"));
    }
    
    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
}


// package com.example.demo.service.impl;
// import com.example.demo.model.Visitor;
// import com.example.demo.repository.VisitorRepository;
// import com.example.demo.service.VisitorService;
// import org.springframework.stereotype.Service;
// import java.util.List;
// @Service
// public class VisitorServiceImpl implements VisitorService {
//     private final VisitorRepository repository;
//     public VisitorServiceImpl(VisitorRepository repository) {
//         this.repository = repository;
//     }
//     @Override
//     public Visitor createVisitor(Visitor visitor) {
//         return repository.save(visitor);
//     }
//     @Override
//     public List<Visitor> getAllVisitors() {
//         return repository.findAll();
//     }
//     @Override
//     public Visitor getVisitorById(Long id) {
//         return repository.findById(id).orElse(null); 
//     }
// }
