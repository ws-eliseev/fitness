package ws.eliseev.fitness.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ws.eliseev.fitness.model.Message;
import ws.eliseev.fitness.repository.IMessageRepository;

import java.util.List;

/**
 * Класс реализует интерфейс доступа к репозиторию
 *
 * @author Разумова Ирина
 * @see IMessageService
 */
@RequiredArgsConstructor
@Service
public class MessageService implements IMessageService{

    private final IMessageRepository iMessageRepository;

    public List<Message> getAllMessage(){
        return iMessageRepository.findAll();
    }

    public Message getMessageById(Long messageId){
        return iMessageRepository.findMessageById(messageId);
    }

    public void deleteMessageById(Long messageId){
        iMessageRepository.deleteById(messageId);
    }

    public Message addMessage(Message message){
        return iMessageRepository.save(message);
    }

    public void editMessage(Message message){
        iMessageRepository.save(message);
    }

    public Message findMessageById(Long messageId) {
        return  iMessageRepository.findMessageById(messageId);
    }
}
