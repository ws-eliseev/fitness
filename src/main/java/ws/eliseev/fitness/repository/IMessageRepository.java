package ws.eliseev.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.eliseev.fitness.model.Message;

/**
 * SpringData CRUD репозиторий для сущности Message
 *
 * @author Разумова Ирина
 */
@Repository

public interface IMessageRepository extends JpaRepository <Message, Long> {
    Message findMessageById(Long messageId);
}
