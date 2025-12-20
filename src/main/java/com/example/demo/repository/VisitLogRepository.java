package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.VisitLog;
public interface VisitLogRepository extends JpaRepository<VisitLog,Long>{

}