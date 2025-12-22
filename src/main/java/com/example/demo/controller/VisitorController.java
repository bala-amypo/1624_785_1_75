// 
package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private final VisitorService service;

    public VisitorController(VisitorService service) {
        this.service = service;
    }

    // CREATE VISITOR
    @PostMapping
    public Visitor createVisitor(@RequestBody Visitor visitor) {
        // directly save; service handles DB
        return service.save(visitor);
    }

    // GET ALL VISITORS
    @GetMapping
    public List<Visitor> getAllVisitors() {
        return service.getAll();
    }

    // GET VISITOR BY ID
    @GetMapping("/{id}")
    public Visitor getVisitor(@PathVariable Long id) {
        // simple find by id; no Optional used
        List<Visitor> all = service.getAll();
        for (Visitor v : all) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        // if not found, return empty visitor to avoid 404
        return Visitor.builder().fullName("Not Found").phone("").build();
    }
}
