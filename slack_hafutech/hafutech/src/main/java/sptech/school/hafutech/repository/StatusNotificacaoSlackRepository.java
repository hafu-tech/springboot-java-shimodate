package sptech.school.hafutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sptech.school.hafutech.entity.StatusNotificacaoSlack;

@Repository
public interface StatusNotificacaoSlackRepository extends JpaRepository<StatusNotificacaoSlack, Long> {
}
