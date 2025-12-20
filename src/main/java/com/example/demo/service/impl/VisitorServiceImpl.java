package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.Visitor;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.VisitorRepository;
import com.example.demo.service.VisitorService;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    @Override
    public Visitor createVisitor(Visitor visitor) {

        // ✅ REQUIRED VALIDATION
        if (visitor.getPhone() == null || visitor.getPhone().trim().isEmpty()) {
            throw new BadRequestException("phone required");
        }

        return visitorRepository.save(visitor);
    }

    @Override
    public Visitor getVisitor(Long id) {
        return visitorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visitor not found"));
    }

    @Override
    public List<Visitor> getAllVisitors() {

        // ✅ NULL-SAFE: never return null
        List<Visitor> visitors = visitorRepository.findAll();
        return visitors; // returns empty list if no records
    }
}
