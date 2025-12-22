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
//     public Visitor getVisitorById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Visitor not found"));
//     }
//     @Override
//     public List<Visitor> getAllVisitors() {
//         return repository.findAll();
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.model.Visitor;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorServiceImpl(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Override
    public Visitor createVisitor(Visitor visitor) {
        if (visitor.getPhone() == null || visitor.getPhone().isEmpty()) {
            throw new BadRequestException("phone required");
        }
        return visitorRepository.save(visitor);
    }

    @Override
    public Visitor getVisitorById(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
    }

    @Override
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
}
