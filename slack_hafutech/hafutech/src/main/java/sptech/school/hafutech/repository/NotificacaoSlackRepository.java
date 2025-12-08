package sptech.school.hafutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sptech.school.hafutech.entity.NotificacaoSlack;


@Repository
public interface NotificacaoSlackRepository extends JpaRepository<NotificacaoSlack, Long> {


}
