package sptech.school.hafutech.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sptech.school.hafutech.config.SlackClientService;
import sptech.school.hafutech.repository.EscolaRepository;
import sptech.school.hafutech.service.NotificacaoService;

@Service
public class ModeloMensagem {

    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    private EscolaRepository escolaRepository;

    public String enviouMensagem() {
        String mensagem = "\uD83D\uDEA8 Novos dados em nosso site.";

        return mensagem;
    }

    public String mensagemAlertaNorte() {
        String mensagem = "";
        System.out.println(escolaRepository.mediaInsePorRegiao("Norte"));
        if (escolaRepository.mediaInsePorRegiao("Norte") < 30) {
            mensagem += pegarMensagemInseCritico("Norte", escolaRepository.mediaInsePorRegiao("Norte"));
        } else if (escolaRepository.mediaInsePorRegiao("Norte") < 50) {
            mensagem += pegarMensagemInseAlerta("Norte", escolaRepository.mediaInsePorRegiao("Norte"));
        }

        mensagem = retornoVazio(mensagem,"Norte");

        return mensagem;
    }
        public String mensagemAlertaNordeste() {
        String mensagem = "";
            if (escolaRepository.mediaInsePorRegiao("Nordeste") < 30) {
                mensagem += pegarMensagemInseCritico("Nordeste", escolaRepository.mediaInsePorRegiao("Nordeste"));
            } else if (escolaRepository.mediaInsePorRegiao("Nordeste") < 50) {
                mensagem += pegarMensagemInseAlerta("Nordeste", escolaRepository.mediaInsePorRegiao("Nordeste"));
            }
            mensagem = retornoVazio(mensagem,"Nordeste");

            return mensagem;
        }

        public String mensagemAlertaSul() {
        String mensagem = "";
            if (escolaRepository.mediaInsePorRegiao("Sul") < 30) {
                mensagem += pegarMensagemInseCritico("Sul", escolaRepository.mediaInsePorRegiao("Sul"));
            } else if (escolaRepository.mediaInsePorRegiao("Sul") < 50) {
                mensagem += pegarMensagemInseAlerta("Sul", escolaRepository.mediaInsePorRegiao("Sul"));
            }
            mensagem = retornoVazio(mensagem,"Sul");

            return mensagem;
        }

        public String mensagemAlertaSudeste() {
        String mensagem = "";
            if (escolaRepository.mediaInsePorRegiao("Sudeste") < 30) {
                mensagem += pegarMensagemInseCritico("Sudeste", escolaRepository.mediaInsePorRegiao("Sudeste"));
            } else if (escolaRepository.mediaInsePorRegiao("Sudeste") < 50) {
                mensagem += pegarMensagemInseAlerta("Sudeste", escolaRepository.mediaInsePorRegiao("Sudeste"));
            }

            mensagem = retornoVazio(mensagem,"Sudeste");

            return mensagem;
        }

    public String mensagemAlertaCentroOeste(){
        String mensagem = "";

        if (escolaRepository.mediaInsePorRegiao("Centro-Oeste") < 30) {
            mensagem += pegarMensagemInseCritico("Centro-Oeste", escolaRepository.mediaInsePorRegiao("Centro-Oeste"));

        } else if (escolaRepository.mediaInsePorRegiao("Centro-Oeste") < 50) {
            mensagem += pegarMensagemInseAlerta("Centro-Oeste", escolaRepository.mediaInsePorRegiao("Centro-Oeste"));
        }

        mensagem = retornoVazio(mensagem,"Centro-Oeste");

        return mensagem;
    }

    String retornoVazio(String mensagem, String regiao) {
        if (mensagem.isEmpty()) {
            return "\n🟢 A região %s está com o INSE(Indicador de Nivel Socioeconômico) crítico".formatted(regiao);
        }
        return mensagem;
    }

    public String pegarMensagemInseCritico(String regiao, Double inse){
        return "\n🔴 Estado crítico: O INSE(Indicador de Nivel Socioeconômico) médio da região %s caiu para %.2f".formatted(regiao,inse);

    }

    public String pegarMensagemInseAlerta(String regiao, Double inse){
        return "\n🟡 Estado em alerta: O INSE(Indicador de Nivel Socioeconômico) médio da região %s caiu para %.2f".formatted(regiao,inse);

    }

}




