package sptech.school.hafutech.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sptech.school.hafutech.message.ModeloMensagem;
import sptech.school.hafutech.service.NotificacaoService;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    private ModeloMensagem modeloMensagem;

    @PostMapping("/geral")
    public void geral() {
        notificacaoService.enviarNotificacao(modeloMensagem.enviouMensagem());
    }

    @PostMapping("/norte")
    public void norte() {
        notificacaoService.enviarNotificacao(modeloMensagem.mensagemAlertaNorte());
    }

    @PostMapping("/nordeste")
    public void nordeste() {
        notificacaoService.enviarNotificacao(modeloMensagem.mensagemAlertaNordeste());
    }

    @PostMapping("/sul")
    public void sul() {
        notificacaoService.enviarNotificacao(modeloMensagem.mensagemAlertaSul());
    }

    @PostMapping("/sudeste")
    public void sudeste() {
        notificacaoService.enviarNotificacao(modeloMensagem.mensagemAlertaSudeste());
    }

    @PostMapping("/centro-oeste")
    public void centroOeste() {
        notificacaoService.enviarNotificacao(modeloMensagem.mensagemAlertaCentroOeste());
    }
}