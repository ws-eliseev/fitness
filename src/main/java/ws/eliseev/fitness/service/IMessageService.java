package ws.eliseev.fitness.service;

import ws.eliseev.fitness.model.Message;

import java.util.List;

/**
 * Сервис для обращения к репозиторию
 * @see ws.eliseev.fitness.repository.IMessageRepository
 * @author Разумова Ирина
 */
public interface IMessageService {
    /**
     * Вывести список всех сообщений
     */
    List<Message> getAllMessage();

    /**
     * Найти сообщение по Id
     *
     * @param messageId - идентификационный номер cooбщения в бд
     */
    Message getMessageById(Long messageId);


    /**
     * Удалить cooбщение по Id
     *
     * @param messageId - идентификационный номер cooбщения в бд
     */
    void deleteMessageById(Long messageId);

    /**
     * Добавить сообщение
     *
     * @param message - объект Message
     */
    Message addMessage(Message message);

    /**
     * Изменить сообщение
     *
     * @param message - объект Message
     */
    void editMessage(Message message);

    /**
     * Найти сообщение по id
     *
     * @param messageId - id искомого сообщения
     */
    Message findMessageById(Long messageId);
}
