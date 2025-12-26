package com.example.demo.controller;

import com.example.demo.model.VisitLog;
import com.example.demo.service.VisitLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/visit-logs")
@Tag(name = "Visit Logs")
public class VisitLogController {
    
    private final VisitLogService visitLogService;
    
    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }
    
    @PostMapping("/visitor/{visitorId}")
    public ResponseEntity<VisitLog> create(@PathVariable Long visitorId, @RequestBody VisitLog visitLog) {
        return ResponseEntity.ok(visitLogService.createVisitLog(visitorId, visitLog));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<VisitLog> get(@PathVariable Long id) {
        return ResponseEntity.ok(visitLogService.getLog(id));
    }
    
    @GetMapping("/visitor/{visitorId}")
    public ResponseEntity<List<VisitLog>> listByVisitor(@PathVariable Long visitorId) {
        return ResponseEntity.ok(visitLogService.getLogsByVisitor(visitorId));
    }
}










// package com.example.demo.controller;
// import com.example.demo.model.VisitLog;
// import com.example.demo.service.VisitLogService;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import java.util.List;
// @RestController
// @RequestMapping("/api/visit-logs")
// public class VisitLogController {
//     private final VisitLogService service;
//     public VisitLogController(VisitLogService service) {
//         this.service = service;
//     }
//     @PostMapping("/{visitorId}")
//     public VisitLog createLog(
//             @PathVariable Long visitorId,
//             @RequestBody VisitLog visitLog) {
//         return service.createVisitLog(visitorId, visitLog);
//     }
//     @GetMapping("/{id}")
//     public VisitLog getLog(@PathVariable Long id) {
//         return service.getVisitLogById(id);
//     }
//     @GetMapping("/visitor/{visitorId}")
//     public List<VisitLog> getLogsByVisitor(@PathVariable Long visitorId) {
//         return service.getLogsByVisitor(visitorId);
//     }
// }
