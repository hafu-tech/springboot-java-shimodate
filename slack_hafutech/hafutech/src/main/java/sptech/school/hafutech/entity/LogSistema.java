package sptech.school.hafutech.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Log_sistema")
public class LogSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime data_hora;

    private String descricacao_log;

    private Integer qtd_registros;

    @ManyToOne
    @JoinColumn(name = "fk_status_id")
    private StatusLogSistema fk_status;
}
