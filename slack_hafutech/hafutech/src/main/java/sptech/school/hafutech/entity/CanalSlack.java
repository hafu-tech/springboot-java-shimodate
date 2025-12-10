package sptech.school.hafutech.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Canal_slack")
public class CanalSlack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    private String webhook;

    @OneToOne
    @JoinColumn(name = "empresa_id")
    private Empresa fk_empresa;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }

    public Empresa getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(Empresa fk_empresa) {
        this.fk_empresa = fk_empresa;
    }
}
