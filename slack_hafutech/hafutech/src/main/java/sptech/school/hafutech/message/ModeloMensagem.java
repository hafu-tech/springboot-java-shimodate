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
        String mensagem = "📢 Novos dados em nosso site.";

        return mensagem;
    }

    public String mensagemAlerta() {
        String mensagem = "";

        if (escolaRepository.mediaInsePorRegiao("Norte") < 3) {
            mensagem += pegarMensagemInse("Norte", escolaRepository.mediaInsePorRegiao("Norte"));
        } if (escolaRepository.mediaInsePorRegiao("Nordeste") < 3) {
            mensagem += pegarMensagemInse("Nordeste", escolaRepository.mediaInsePorRegiao("Nordeste"));
        } /*if (escolaRepository.mediaInsePorRegiao("Sul") < 3) {
            mensagem += pegarMensagemInse("Sul", escolaRepository.mediaInsePorRegiao("Sul"));
        } if (escolaRepository.mediaInsePorRegiao("Sudeste") < 3) {
            mensagem += pegarMensagemInse("Sudeste", escolaRepository.mediaInsePorRegiao("Sudeste"));
        } if (escolaRepository.mediaInsePorRegiao("Centro-Oeste") < 3) {
         mensagem += pegarMensagemInse("Centro-Oeste", escolaRepository.mediaInsePorRegiao("Centro-Oeste"));
        }*/

        if(mensagem.isEmpty()){
            return "🟢 Nenhuma região está com o INSE(Indicador de Nivel Socioeconômico) crítico";
        }

    return mensagem;
    }

    public String pegarMensagemInse(String regiao, Double inse){
        return "\n \uD83D\uDEA8 Alerta crítico: O INSE(Indicador de Nivel Socioeconômico) médio da região %s caiu para %.2f".formatted(regiao,inse);

    }

}




