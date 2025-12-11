package sptech.school.hafutech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.stereotype.Component;
import sptech.school.hafutech.message.ModeloMensagem;
import sptech.school.hafutech.service.NotificacaoService;
@Component
public class NotificacaoStartRunner implements ApplicationRunner {

    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    private ModeloMensagem modeloMensagem;

    @Override
    public void run(ApplicationArguments args) {

        notificacaoService.enviarNotificacao(modeloMensagem.enviouMensagem());
        notificacaoService.enviarNotificacao(modeloMensagem.mensagemAlertaNorte());
        notificacaoService.enviarNotificacao(modeloMensagem.mensagemAlertaNordeste());
        notificacaoService.enviarNotificacao(modeloMensagem.mensagemAlertaSul());
        notificacaoService.enviarNotificacao(modeloMensagem.mensagemAlertaSudeste());
        notificacaoService.enviarNotificacao(modeloMensagem.mensagemAlertaCentroOeste());

        System.out.println("Dados Enviado..");

        System.exit(0);
    }
}

