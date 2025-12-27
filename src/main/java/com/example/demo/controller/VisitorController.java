package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
@Tag(name = "Visitor")
public class VisitorController {

    private final VisitorService service;

    public VisitorController(VisitorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Visitor> create(@RequestBody Visitor v) {
        return ResponseEntity.ok(service.createVisitor(v));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> get(@PathVariable long id) {
        return ResponseEntity.ok(service.getVisitor(id));
    }

    @GetMapping
    public ResponseEntity<List<Visitor>> all() {
        return ResponseEntity.ok(service.getAllVisitors());
    }
}


// package com.example.demo.controller;

// import com.example.demo.model.Visitor;
// import com.example.demo.service.VisitorService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.http.ResponseEntity;

// import java.util.List;

// @Tag(name = "Visitor")
// public class VisitorController {

//     private final VisitorService service;

//     public VisitorController(VisitorService service) {
//         this.service = service;
//     }

//     public ResponseEntity<Visitor> create(Visitor v) {
//         return ResponseEntity.ok(service.createVisitor(v));
//     }

//     public ResponseEntity<Visitor> get(long id) {
//         return ResponseEntity.ok(service.getVisitor(id));
//     }

//     public ResponseEntity<List<Visitor>> all() {
//         return ResponseEntity.ok(service.getAllVisitors());
//     }
// }
