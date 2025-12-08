package sptech.school.hafutech.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sptech.school.hafutech.config.SlackClientService;
import sptech.school.hafutech.service.NotificacaoService;

@Service
public class ModeloMensagem {

    @Autowired
    private NotificacaoService notificacaoService;

    public String enviouMensagem() {
        String mensagem = "📢 Novos dados em nosso site.";


        notificacaoService.enviarNotificacao(mensagem);
        return mensagem;
    }
}




