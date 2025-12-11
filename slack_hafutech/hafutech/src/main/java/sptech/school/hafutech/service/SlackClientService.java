package sptech.school.hafutech.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class SlackClientService {

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean enviarMensagem(String webhook, String mensagem) {
        restTemplate.postForEntity(webhook, Map.of("text", mensagem), String.class);
        return true;
    }
}