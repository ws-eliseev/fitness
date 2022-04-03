package ws.eliseev.fitness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.dto.UserDto;
import ws.eliseev.fitness.repository.IMailRepository;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service
public class MailService implements IMailService{

    private final IMailRepository mailRepository;
    private final JavaMailSender mailSender;

    private static final String MAIL_SUBJECT = "Смена пароля";
    private static final String MAIL_USERNAME = "username";
    private static final String MAIL_PASSWORD = "password";

    @Autowired
    public MailService(IMailRepository mailRepository, JavaMailSender mailSender) {
        this.mailRepository = mailRepository;
        this.mailSender = mailSender;
    }


    @Override
    public void sendNewPassword(UserDto user) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
        message.setSubject(MAIL_SUBJECT);
        message.setContent(mailRepository.getById(1L).getTemplate()
                .replace(MAIL_USERNAME, user.getUsername())
                .replace(MAIL_PASSWORD, user.getPassword()), "text/html; charset=utf-8");

        mailSender.send(message);
    }
}
