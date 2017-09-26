package scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    @Inject
    EmailService emailService;
    @Inject
    Service service;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 600000)
    public void run() throws Exception {
        try {
            System.out.println("Iniciado em " + dateFormat.format(new Date()));
            String result = service.get();
            System.out.println("retorno :" + result);
            emailService.sendEmail(result);
            System.out.println("Finalizado em " + dateFormat.format(new Date()));

        } catch (Exception e) {
            System.out.println("ERRO" + e.getMessage());
        }
    }
}