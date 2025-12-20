import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ScoreAuditLogRepository extends JpaRepository<ScoreAuditLog, Long> {

    // Finds all audit logs for a specific visitor
    List<ScoreAuditLog> findByVisitorId(Long visitorId);
}
