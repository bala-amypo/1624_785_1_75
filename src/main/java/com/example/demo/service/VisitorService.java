package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Visitor;

public interface VisitorService {

    Visitor createVisitor(Visitor visitor);

    Visitor getVisitor(Long id);

    List<Visitor> getAllVisitors();
}
