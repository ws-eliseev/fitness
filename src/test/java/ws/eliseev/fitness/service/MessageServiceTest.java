package ws.eliseev.fitness.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ws.eliseev.fitness.model.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(SpringExtension.class)
@SpringBootTest
class MessageServiceTest {

    private Message createdMessage;

    private IMessageService iMessageService;

    @Autowired
    public MessageServiceTest(IMessageService iMessageService) {
        this.iMessageService = iMessageService;
    }


    @BeforeEach
    public void initMethod() {
        createdMessage = new Message();
        createdMessage.setId(1L);
        createdMessage.setContent("test msg");
        createdMessage.setSenderName("test user");
        createdMessage.setBlob(new byte[] {1,2,3});
        createdMessage.setTimestamp(new Date(1111111));
    }

    @Test
    void getAllMessageTest() {
        List<Message> listMessage = new ArrayList<>();
        iMessageService.addMessage(createdMessage);
        listMessage.add(createdMessage);

        Optional<List<Message>> optionalFoundedListMessage = ofNullable(iMessageService.getAllMessage());
        optionalFoundedListMessage.ifPresent(messages -> assertEquals(listMessage, optionalFoundedListMessage.get(), "list not equals"));
    }


    @Test
    public void getMessageByIdTest() {


        iMessageService.addMessage(createdMessage);

        Optional<Message> messageById = ofNullable(iMessageService.getMessageById(createdMessage.getId()));
        messageById.ifPresent(message -> assertEquals(createdMessage, messageById.get()));

    }

    @Test
    public void deleteMessageByIdTest() {

        iMessageService.addMessage(createdMessage);
        iMessageService.deleteMessageById(createdMessage.getId());

        assertEquals(null, iMessageService.findMessageById(createdMessage.getId()));
    }


    @Test
    public void editMessageTest() {

        iMessageService.addMessage(createdMessage);

        Message editedMessage = iMessageService.findMessageById(createdMessage.getId());
        editedMessage.setContent("ms");
        editedMessage.setSenderName("ur");
        editedMessage.setBlob(new byte[] {11,22});
        editedMessage.setTimestamp(new Date(2222222));
        iMessageService.editMessage(editedMessage);

        Optional<Message> optionalFoundedMessage = Optional.ofNullable(iMessageService.findMessageById(editedMessage.getId()));
        optionalFoundedMessage.ifPresent(message -> assertEquals(editedMessage, optionalFoundedMessage.get(),"messages not equals"));
      }

    @Test
    public void addMessageTest() {

        Optional<Message> createdMess = Optional.ofNullable(iMessageService.addMessage(createdMessage));
        createdMess.ifPresent(message -> assertEquals(createdMessage, createdMess.get(), "messages not equals"));
    }
}