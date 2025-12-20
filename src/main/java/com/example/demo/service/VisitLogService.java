package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.VisitLog;

public interface VisitLogService {

    VisitLog createVisitLog(Long visitorId, VisitLog log);

    VisitLog getLog(Long id);

    List<VisitLog> getLogsByVisitor(Long visitorId);
}
