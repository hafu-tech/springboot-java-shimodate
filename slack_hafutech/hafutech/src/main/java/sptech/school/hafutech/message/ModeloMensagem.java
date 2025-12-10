package sptech.school.hafutech.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sptech.school.hafutech.config.SlackClientService;
import sptech.school.hafutech.repository.EscolaRepository;
import sptech.school.hafutech.service.NotificacaoService;
@Service
public class ModeloMensagem {

    @Autowired
    private EscolaRepository escolaRepository;

    public String enviouMensagem() {
        return "🚨 Novos dados em nosso site.";
    }

    public String mensagemAlertaNorte() {
        return gerarMensagem("Norte");
    }

    public String mensagemAlertaNordeste() {
        return gerarMensagem("Nordeste");
    }

    public String mensagemAlertaSul() {
        return gerarMensagem("Sul");
    }

    public String mensagemAlertaSudeste() {
        return gerarMensagem("Sudeste");
    }

    public String mensagemAlertaCentroOeste() {
        return gerarMensagem("Centro-Oeste");
    }

    private String gerarMensagem(String regiao) {

        Double inse = escolaRepository.mediaInsePorRegiao(regiao);

        if (inse == null) {
            return "⚠️ Nenhum dado encontrado para a região: " + regiao;
        }

        if (inse < 30) {
            return pegarMensagemInseCritico(regiao, inse);
        }
        else if (inse < 50) {
            return pegarMensagemInseAlerta(regiao, inse);
        }

        return "🟢 A região %s está com o INSE estável (%.2f)."
                .formatted(regiao, inse);
    }

    String retornoVazio(String mensagem, String regiao) {
        if (mensagem.isEmpty()) {
            return "\n🟢 A região %s está com o INSE crítico".formatted(regiao);
        }
        return mensagem;
    }

    public String pegarMensagemInseCritico(String regiao, Double inse){
        return "\n🔴 Estado crítico: O INSE médio da região %s caiu para %.2f".formatted(regiao,inse);

    }

    public String pegarMensagemInseAlerta(String regiao, Double inse){
        return "\n🟡 Estado em alerta: O INSE(Indicador de Nivel Socioeconômico) médio da região %s caiu para %.2f".formatted(regiao,inse);

    }

}




