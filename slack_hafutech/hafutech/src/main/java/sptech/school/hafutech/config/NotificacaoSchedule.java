package sptech.school.hafutech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sptech.school.hafutech.message.ModeloMensagem;
import sptech.school.hafutech.service.NotificacaoService;

@Component
@EnableScheduling
public class NotificacaoSchedule {

    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    private ModeloMensagem modeloMensagem;

    @Scheduled(cron = "0 */1 * * * *")
    public void executar() {
        notificacaoService.enviarNotificacao(modeloMensagem.enviouMensagem());
        notificacaoService.enviarMensagemPorRegiao(modeloMensagem.mensagemAlertaNorte());
        notificacaoService.enviarMensagemPorRegiao(modeloMensagem.mensagemAlertaNordeste());
        notificacaoService.enviarMensagemPorRegiao(modeloMensagem.mensagemAlertaSul());
        notificacaoService.enviarMensagemPorRegiao(modeloMensagem.mensagemAlertaSudeste());
        notificacaoService.enviarMensagemPorRegiao(modeloMensagem.mensagemAlertaCentroOeste());

           System.out.println("Enviando dados..");
    }
}


