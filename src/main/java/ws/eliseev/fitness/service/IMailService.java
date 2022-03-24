package ws.eliseev.fitness.service;

import ws.eliseev.fitness.dto.UserDto;

import javax.mail.MessagingException;

public interface IMailService {
    void sendNewPassword(UserDto user) throws MessagingException;
}
