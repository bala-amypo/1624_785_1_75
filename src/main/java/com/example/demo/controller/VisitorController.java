// 
package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        // call interface method
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
