package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Jparepository;
import com.example.demo.model.VisitLog;
@Repository
public interface VisitLogRepository extends Jparepository<VisitLog,Long>{

}