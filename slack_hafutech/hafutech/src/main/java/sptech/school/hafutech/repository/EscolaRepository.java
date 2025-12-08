package sptech.school.hafutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sptech.school.hafutech.entity.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {




}
