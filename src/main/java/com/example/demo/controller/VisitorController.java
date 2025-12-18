package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.VisitorService;
@RestController
@RequestMapping("/api/visitors")
public class VisitorController {
    @Autowired
    VisitorService visitorService;
    @PostMapping
    public Object createVisitor(@RequestBody Object visitor) {
        return visitorService.createVisitor(visitor);
    }
    @GetMapping
    public Object listVisitors() {
        return visitorService.getAllVisitors();
    }
    @GetMapping("/{id}")
    public Object getVisitor(@PathVariable Long id) {
        return visitorService.getVisitorById(id);
    }
}