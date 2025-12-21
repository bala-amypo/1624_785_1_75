package com.example.demo.controller;

import com.example.demo.entity.Visitor;
import com.example.demo.service.VisitorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorService service;

    public VisitorController(VisitorService service) {
        this.service = service;
    }

    @PostMapping
    public Visitor createVisitor(@RequestBody Visitor visitor) {
        return service.createVisitor(visitor);
    }

    @GetMapping("/{id}")
    public Visitor getVisitor(@PathVariable Long id) {
        return service.getVisitorById(id);
    }

    @GetMapping
    public List<Visitor> getAllVisitors() {
        return service.getAllVisitors();
    }
}
