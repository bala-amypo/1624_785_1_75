package com.example.demo.controller;

@RestController
@RequestMapping("/api/visit-logs")
public class VisitLogController {

    private final VisitLogService service;

    public VisitLogController(VisitLogService service) {
        this.service = service;
    }

    @PostMapping("/{visitorId}")
    public VisitLog createLog(
            @PathVariable Long visitorId,
            @RequestBody VisitLog visitLog) {
        return service.createVisitLog(visitorId, visitLog);
    }

    @GetMapping("/{id}")
    public VisitLog getLog(@PathVariable Long id) {
        return service.getVisitLogById(id);
    }

    @GetMapping("/visitor/{visitorId}")
    public List<VisitLog> getLogsByVisitor(@PathVariable Long visitorId) {
        return service.getLogsByVisitor(visitorId);
    }
}
