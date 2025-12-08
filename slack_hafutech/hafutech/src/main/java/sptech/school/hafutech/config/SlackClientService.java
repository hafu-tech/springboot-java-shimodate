package sptech.school.hafutech.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sptech.school.hafutech.service.NotificacaoService;

import java.util.Map;

@Service
public class SlackClientService {

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean enviarMensagem(String webhook, String mensagem) {
        restTemplate.postForEntity(webhook, Map.of("text", mensagem), String.class);
        return true;
    }
}