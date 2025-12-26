package com.example.demo.controller;

import com.example.demo.model.Visitor;
import com.example.demo.service.VisitorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/visitors")
@RequiredArgsConstructor
@Tag(name = "VisitorController")
public class VisitorController {

    // Made public or accessible for test setup constructing it manually
    private final VisitorService visitorService;

    @PostMapping
    public ResponseEntity<Visitor> create(@RequestBody Visitor visitor) {
        return ResponseEntity.ok(visitorService.createVisitor(visitor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> get(@PathVariable Long id) {
        return ResponseEntity.ok(visitorService.getVisitor(id));
    }

    @GetMapping
    public ResponseEntity<List<Visitor>> all() {
        return ResponseEntity.ok(visitorService.getAllVisitors());
    }
}

// package com.example.demo.controller;
// import com.example.demo.model.Visitor;
// import com.example.demo.service.VisitorService;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import java.util.List;
// @RestController
// @RequestMapping("/api/visitors")
// public class VisitorController {
//     private final VisitorService service;
//     public VisitorController(VisitorService service) {
//         this.service = service;
//     }
//     @PostMapping
//     public Visitor createVisitor(@RequestBody Visitor visitor) {
//         return service.createVisitor(visitor);
//     }
//     @GetMapping("/{id}")
//     public Visitor getVisitor(@PathVariable Long id) {
//         return service.getVisitorById(id);
//     }
//     @GetMapping
//     public List<Visitor> getAllVisitors() {
//         return service.getAllVisitors();
//     }
// }
