package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.Visitor;

public interface VisitorService {

    Visitor createVisitor(Visitor visitor);

    Visitor getVisitor(Long id);

    List<Visitor> getAllVisitors();
}
