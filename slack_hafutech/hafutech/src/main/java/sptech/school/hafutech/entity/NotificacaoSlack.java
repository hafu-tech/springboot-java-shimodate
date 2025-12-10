package sptech.school.hafutech.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "notificacao_slack")
public class NotificacaoSlack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mensagem")
    private String mensagem;

    private LocalDateTime dataEnvio;

    @ManyToOne
    @JoinColumn(name = "fk_empresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "parametrizacao_notificacao_usuario_id")
    private ParametrizacaoNotificacaoUsuario parametroUsuario;

    @ManyToOne
    @JoinColumn(name = "status_notificacao_slack_id")
    private StatusNotificacaoSlack statusNotificacaoSlack;

    @ManyToOne
    @JoinColumn(name = "status_slack_atividade_id")
    private StatusSlackAtividade statusSlackAtividade;


    public NotificacaoSlack() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDateataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public ParametrizacaoNotificacaoUsuario getParametro() {
        return parametroUsuario;
    }

    public void setParametro(ParametrizacaoNotificacaoUsuario parametro) {
        this.parametroUsuario = parametro;
    }

    public StatusSlackAtividade getStatusAtividade() {
        return statusSlackAtividade;
    }

    public void setStatusAtividade(StatusSlackAtividade statusAtividade) {
        this.statusSlackAtividade = statusAtividade;
    }

    public StatusNotificacaoSlack getStatusSlack() {
        return statusNotificacaoSlack;
    }

    public void setStatusSlack(StatusNotificacaoSlack statusSlack) {
        this.statusNotificacaoSlack = statusSlack;
    }
}

