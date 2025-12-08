package sptech.school.hafutech.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Parametrizacao_notificacao_usuario")
public class ParametrizacaoNotificacaoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeParametro;
    private String parametro;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeParametro() {
        return nomeParametro;
    }

    public void setNomeParametro(String nomeParametro) {
        this.nomeParametro = nomeParametro;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
}