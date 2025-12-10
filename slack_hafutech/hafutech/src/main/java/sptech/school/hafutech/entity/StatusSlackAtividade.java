package sptech.school.hafutech.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Status_slack_atividade")
public class StatusSlackAtividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private EstadoSlack estado = EstadoSlack.INATIVO;

    private LocalDate data_agendamento;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoSlack getEstado() {
        return estado;
    }

    public void setEstado(EstadoSlack estado) {
        this.estado = estado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public LocalDate getData_agendamento() {
        return data_agendamento;
    }
}
