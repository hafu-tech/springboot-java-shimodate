package sptech.school.hafutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sptech.school.hafutech.entity.Empresa;
import sptech.school.hafutech.entity.StatusSlackAtividade;


@Repository
public interface StatusSlackAtividadeRepository extends JpaRepository<StatusSlackAtividade, Integer> {
    StatusSlackAtividade findByEmpresaId(Integer empresaId);


}
