package com.example.demo.service;

import com.example.demo.model.VisitLog;
import java.util.List;

public interface VisitLogService {

    VisitLog createVisitLog(Long visitorId, VisitLog visitLog);

    VisitLog getVisitLogById(Long id);

    List<VisitLog> getLogsByVisitor(Long visitorId);
}
