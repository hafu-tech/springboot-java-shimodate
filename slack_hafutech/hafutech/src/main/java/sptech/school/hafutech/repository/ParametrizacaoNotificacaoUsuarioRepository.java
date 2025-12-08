package sptech.school.hafutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sptech.school.hafutech.entity.ParametrizacaoNotificacaoUsuario;

@Repository
public interface ParametrizacaoNotificacaoUsuarioRepository extends JpaRepository<ParametrizacaoNotificacaoUsuario, Long> {
}
