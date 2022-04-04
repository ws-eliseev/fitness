package ws.eliseev.fitness.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import ws.eliseev.fitness.dto.UserDto;
import ws.eliseev.fitness.repository.IUserRepository;
import ws.eliseev.fitness.util.mapper.IUserMapper;

@Log4j2
@Service(value = "Kafka")
public class KafkaUserService extends UserService{
    private final KafkaTemplate<Long, UserDto> kafkaTemplate;
    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;

    public KafkaUserService(IUserRepository repository, IUserMapper iUserMapper, KafkaTemplate<Long, UserDto> kafkaTemplate) {
        super(repository, iUserMapper);
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void saveUserOrUpdate(UserDto user) {
        //Не решил, какой ключ использовать
        ListenableFuture<SendResult<Long, UserDto>> future = kafkaTemplate.send(defaultTopic, 1L, user);
        //Надо какие-нибудь пояснения добавить в лог?
        future.addCallback(log::info, log::info);
        super.saveUserOrUpdate(user);
    }
}
