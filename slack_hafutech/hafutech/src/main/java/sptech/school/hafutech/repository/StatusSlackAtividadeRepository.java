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
public interface StatusSlackAtividadeRepository extends JpaRepository<StatusSlackAtividade, Integer> {
    StatusSlackAtividade findByEmpresaId(Integer empresa_id);
=======
public interface StatusSlackAtividadeRepository extends JpaRepository<StatusSlackAtividade, Long> {
>>>>>>> ba0bfcc824500a20ee00b2ca526ee271752f9cff

    @Query(value = "SELECT ssa.estado FROM Status_slack_atividade ssa WHERE ssa.empresa_id = :empresa_id",nativeQuery = true)
    EstadoSlack retornaEstadoPeloId(@Param("empresa_id") Integer empresaId);

}
