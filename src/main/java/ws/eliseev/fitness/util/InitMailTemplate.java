package ws.eliseev.fitness.util;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ws.eliseev.fitness.model.Mail;
import ws.eliseev.fitness.repository.IMailRepository;

@Component
@Profile("dev")
public class InitMailTemplate {

    private final IMailRepository mailRepository;

    public InitMailTemplate (IMailRepository mailRepository) {
        this.mailRepository = mailRepository;

        Mail mail = new Mail();
        mail.setTemplate("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title></title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h4>Пароль успешно изменен</h5>\n" +
                "<h4>Ваш логин: username</h5>\n" +
                "<h4>Ваш пароль: password</h5>\n" +
                "</body>\n" +
                "</html>");

        mailRepository.save(mail);
    }
}
