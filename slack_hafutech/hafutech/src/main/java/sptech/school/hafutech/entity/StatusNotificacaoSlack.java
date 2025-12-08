package sptech.school.hafutech.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Status_notificacao_slack")
public class StatusNotificacaoSlack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String codigoStatusHttp;
    private String classificacaoStatus;
    private String descricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoStatusHttp() {
        return codigoStatusHttp;
    }

    public void setCodigoStatusHttp(String codigoStatusHttp) {
        this.codigoStatusHttp = codigoStatusHttp;
    }

    public String getClassificacaoStatus() {
        return classificacaoStatus;
    }

    public void setClassificacaoStatus(String classificacaoStatus) {
        this.classificacaoStatus = classificacaoStatus;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}