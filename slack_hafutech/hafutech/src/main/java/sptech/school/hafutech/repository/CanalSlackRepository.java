package sptech.school.hafutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sptech.school.hafutech.entity.CanalSlack;

@Repository
public interface CanalSlackRepository extends JpaRepository<CanalSlack, Long> {
    @Query(value = "SELECT webhook FROM Canal_slack ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String retornarWebhook();
}
