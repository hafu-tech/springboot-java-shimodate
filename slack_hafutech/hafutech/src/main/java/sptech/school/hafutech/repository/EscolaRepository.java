package sptech.school.hafutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sptech.school.hafutech.entity.Escola;

import java.util.List;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {

    @Query(value = "SELECT COALESCE(ROUND(AVG(e.valor_inse),2),0) FROM Escola e WHERE e.regiao = :regiao ORDER BY e.id DESC LIMIT 17000", nativeQuery = true)
    Double mediaInsePorRegiao(@Param("regiao") String regiao);


}
