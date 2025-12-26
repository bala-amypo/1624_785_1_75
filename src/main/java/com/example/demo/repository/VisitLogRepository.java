package com.example.demo.repository;

import com.example.demo.model.VisitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {
    List<VisitLog> findByVisitorSince(Long visitorId, LocalDateTime since);
    
    @Query("SELECT COUNT(v) FROM VisitLog v WHERE v.visitor.id = ?1 AND v.entryTime BETWEEN ?2 AND ?3")
    Long countVisitsInWindow(Long visitorId, LocalDateTime start, LocalDateTime end);
}


// package com.example.demo.repository;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.VisitLog;
// import java.time.LocalDateTime;
// import java.util.List;
// public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {
//     List<VisitLog> findByVisitorId(Long visitorId);
//     List<VisitLog> findByVisitorIdAndEntryTimeAfter(
//             Long visitorId, LocalDateTime time
//     );
// }
