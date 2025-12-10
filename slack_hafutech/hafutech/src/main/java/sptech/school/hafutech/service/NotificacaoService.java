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
    private final EmpresaRepository empresaRepository;
    @Autowired
    private final ParametrizacaoNotificacaoUsuarioRepository parametrizacaoRepository;
    @Autowired
    private final StatusSlackAtividadeRepository statusSlackRepository;
    @Autowired
    private final NotificacaoSlackRepository notificacaoSlackRepository;
    @Autowired
    private final StatusNotificacaoSlackRepository statusNotificacaoSlackRepository;
    @Autowired
    private final SlackClientService slackClient;
    @Autowired
    private final CanalSlackRepository canalSlackRepository;

    public NotificacaoService(EmpresaRepository empresaRepository, ParametrizacaoNotificacaoUsuarioRepository parametrizacaoRepository, StatusSlackAtividadeRepository statusSlackRepository, NotificacaoSlackRepository notificacaoSlackRepository, StatusNotificacaoSlackRepository statusNotificacaoSlackRepository, SlackClientService slackClient, CanalSlackRepository canalSlackRepository) {
        this.empresaRepository = empresaRepository;
        this.parametrizacaoRepository = parametrizacaoRepository;
        this.statusSlackRepository = statusSlackRepository;
        this.notificacaoSlackRepository = notificacaoSlackRepository;
        this.statusNotificacaoSlackRepository = statusNotificacaoSlackRepository;
        this.slackClient = slackClient;
        this.canalSlackRepository = canalSlackRepository;
    }

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
        return true;
    }
    }
