package sptech.school.hafutech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sptech.school.hafutech.controller.NotificacaoController;

@SpringBootApplication
public class HafutechApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(HafutechApplication.class, args);

        NotificacaoController controller = context.getBean(NotificacaoController.class);

        controller.processarNotificacao();
    }


}
