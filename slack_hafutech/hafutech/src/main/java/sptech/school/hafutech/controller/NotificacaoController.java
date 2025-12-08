package sptech.school.hafutech.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.hafutech.config.SlackClientService;
import sptech.school.hafutech.entity.Empresa;
import sptech.school.hafutech.entity.Escola;
import sptech.school.hafutech.entity.NotificacaoSlack;
import sptech.school.hafutech.message.ModeloMensagem;
import sptech.school.hafutech.repository.EmpresaRepository;
import sptech.school.hafutech.repository.EscolaRepository;
import sptech.school.hafutech.repository.NotificacaoSlackRepository;
import sptech.school.hafutech.service.NotificacaoService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/teste")
public class NotificacaoController {

    @Autowired
    private final NotificacaoService notificacaoService;

    @Autowired
    private final EscolaRepository escolaRepository;

    @Autowired
    private NotificacaoSlackRepository notificacaoSlackRepository;

    @Autowired
    private SlackClientService slackClientService;

    @Autowired
    private ModeloMensagem modeloMensagem;

    @Autowired
    private EmpresaRepository empresaRepository;


    public NotificacaoController(NotificacaoService notificacaoService, EscolaRepository escolaRepository) {
        this.notificacaoService = notificacaoService;
        this.escolaRepository = escolaRepository;
    }

    @PostMapping("/processar")
        public void processarNotificacao() {
            NotificacaoSlack notificacaoSlack = new NotificacaoSlack();

            notificacaoSlack.setMensagem(modeloMensagem.enviouMensagem());
            notificacaoSlack.setDataEnvio(LocalDate.now());


        notificacaoSlackRepository.save(notificacaoSlack);
    }
}
