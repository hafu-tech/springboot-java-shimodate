package sptech.school.hafutech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sptech.school.hafutech.config.SlackClientService;
import sptech.school.hafutech.entity.Escola;
import sptech.school.hafutech.entity.EstadoSlack;
import sptech.school.hafutech.entity.NotificacaoSlack;
import sptech.school.hafutech.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class NotificacaoService {

    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private ParametrizacaoNotificacaoUsuarioRepository parametrizacaoRepository;
    @Autowired
    private StatusSlackAtividadeRepository statusSlackRepository;
    @Autowired
    private NotificacaoSlackRepository notificacaoSlackRepository;
    @Autowired
    private StatusNotificacaoSlackRepository statusNotificacaoSlackRepository;
    @Autowired
    private SlackClientService slackClient;
    @Autowired
    private CanalSlackRepository canalSlackRepository;



    public String retornarWebhook() {
        return canalSlackRepository.retornarWebhook();
    }


    public Boolean verUsuarioAtivo() {

        EstadoSlack status = statusSlackRepository.retornaEstadoPeloId(empresaRepository.pegarUltimoId());

        if(status == null) {
            status = EstadoSlack.INATIVO;
        }

         if (status == EstadoSlack.INATIVO) return false;

        return true;
        }

    public boolean enviarNotificacao(String mensagem) {
        String webhook = retornarWebhook();

        if(!verUsuarioAtivo()){
            return false;
        }

        slackClient.enviarMensagem(webhook, mensagem);

        NotificacaoSlack log = new NotificacaoSlack();
        log.setMensagem(mensagem);
        log.setDateataEnvio(LocalDateTime.now());

        notificacaoSlackRepository.save(log);

        return true;
    }

    public void enviarMensagemPorRegiao(String mensagem) {
        enviarNotificacao(mensagem);
    }

    }
