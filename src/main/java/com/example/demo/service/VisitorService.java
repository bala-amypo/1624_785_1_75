package com.example.demo.service;

import com.example.demo.entity.Visitor;
import java.util.List;

public interface VisitorService {

    Visitor createVisitor(Visitor visitor);

    Visitor getVisitorById(Long id);

    List<Visitor> getAllVisitors();
}
