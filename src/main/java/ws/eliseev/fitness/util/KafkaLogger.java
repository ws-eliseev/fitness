package ws.eliseev.fitness.util;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ws.eliseev.fitness.dto.UserDto;

//Так нормально, или лучше в FitnessApplication перенести метод?
@Log4j2
@Component
public class KafkaLogger {
    //Не понял, как засунуть сюда из yaml
    @KafkaListener(topics = "fit-user")
    public void msgListener(ConsumerRecord<Long, UserDto> consumerRecord){
        log.info("Был добавлен или изменён пользователь: " + consumerRecord.value());
    }
}
