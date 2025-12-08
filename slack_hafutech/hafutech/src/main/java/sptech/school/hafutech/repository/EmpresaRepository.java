package sptech.school.hafutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sptech.school.hafutech.entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Query("SELECT id FROM Empresa ORDER BY id DESC LIMIT 1")
    Long pegarUltimoId();

}
