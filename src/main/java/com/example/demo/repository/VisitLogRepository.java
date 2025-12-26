package com.example.demo.repository;

import com.example.demo.model.VisitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {

    @Query("SELECT v FROM VisitLog v WHERE v.visitor.id = :visitorId AND v.entryTime >= :since")
    List<VisitLog> findByVisitorSince(Long visitorId, LocalDateTime since);

    @Query("SELECT COUNT(v) FROM VisitLog v WHERE v.visitor.id = :visitorId AND v.entryTime BETWEEN :start AND :end")
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
