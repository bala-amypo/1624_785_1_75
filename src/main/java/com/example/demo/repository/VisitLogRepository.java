package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.VisitLog;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {

    List<VisitLog> findByVisitorId(Long visitorId);

    List<VisitLog> findByVisitorIdAndEntryTimeAfter(
            Long visitorId, LocalDateTime time
    );
}
