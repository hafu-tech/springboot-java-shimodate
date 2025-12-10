package sptech.school.hafutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sptech.school.hafutech.entity.Empresa;
import sptech.school.hafutech.entity.EstadoSlack;
import sptech.school.hafutech.entity.StatusSlackAtividade;


@Repository
<<<<<<< HEAD
public interface StatusSlackAtividadeRepository extends JpaRepository<StatusSlackAtividade, Long> {

    @Query("SELECT ssa.estado FROM Status_slack_ativade ssa WHERE ssa.empresa_id = :empresa_id")
    EstadoSlack findByEmpresaId(@Param("empresa_id") Integer empresaId);
=======
public interface StatusSlackAtividadeRepository extends JpaRepository<StatusSlackAtividade, Integer> {
    StatusSlackAtividade findByEmpresaId(Integer empresaId);
>>>>>>> cf20c29bd1d0887fed31c88850a464236d191f2c


}
