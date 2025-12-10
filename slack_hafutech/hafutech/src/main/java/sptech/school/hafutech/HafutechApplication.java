package sptech.school.hafutech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import sptech.school.hafutech.controller.NotificacaoController;

@SpringBootApplication
@EnableScheduling
public class HafutechApplication {
    public static void main(String[] args) {
        SpringApplication.run(HafutechApplication.class, args);
    }
}
