package scheduler;

/**
 * Created by vande on 07/04/2016.
 */

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailConstants;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

@org.springframework.stereotype.Service
public class EmailService {

    private static final String HOST_NAME = "smtp.gmail.com";
    private static final String EMAIL_FROM = "email@gmail.com";
    private static final String EMAIL_TO = "email";
    private static final String SENHA = "senha";
    private static final String ASSUNTO = "Report Scheduler";
    private static final Integer PORTA = 465;

    public void sendEmail(String corpo) throws EmailException {

        ImageHtmlEmail email = new ImageHtmlEmail();
        email.setDataSourceResolver(new DataSourceUrlResolver(null));
        email.setHostName(HOST_NAME);
        email.setSSLOnConnect(true);
        email.setAuthenticator(new DefaultAuthenticator(EMAIL_FROM, SENHA));
        email.setStartTLSEnabled(false);
        email.setStartTLSRequired(false);
        email.setCharset(EmailConstants.UTF_8);
        email.setFrom(EMAIL_FROM);
        email.addTo(EMAIL_TO);
        email.setSubject(ASSUNTO);
        email.setHtmlMsg(corpo);
        email.setTextMsg("O seu cliente de email nao suporta mensagens em HTML.");
        email.send();
    }
}
