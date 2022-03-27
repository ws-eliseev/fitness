package ws.eliseev.fitness.service;

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

    private IMessageService iMessageService;
    @Autowired
    public MessageServiceTest(IMessageService iMessageService) {
        this.iMessageService = iMessageService;
    }

//    @Test
//    void getAllMessageTest() {
//        Optional<List<Message>> optionalGetAllMessage = ofNullable(iMessageService.getAllMessage());
//        optionalGetAllMessage.ifPresent(listMessage -> {
//            Message message;
//            List.of(message = new Message());
//            message.setId(1L);
//            message.setContent("ms");
//            message.setSenderName("ur");
//            message.setBlob(new byte[]{11, 22});
//            message.setTimestamp(new Date(2222222L));
////            iMessageService.getAllMessage();
//        });
//
//        Optional<List<Message>> optionalFoundedListMessage = ofNullable(iMessageService.getAllMessage());
//        optionalFoundedListMessage.ifPresent(message -> assertEquals(optionalGetAllMessage, optionalFoundedListMessage, "list not equals"));
//    }

    @Test
    void getAllMessageTest() {
        List<Message> listMessage = new ArrayList<>();
        Message createdMessage = new Message();
        createdMessage.setId(1L);
        createdMessage.setContent("test msg");
        createdMessage.setSenderName("test user");
        createdMessage.setBlob(new byte[] {1,2,3});
        createdMessage.setTimestamp(new Date(1111111));
        iMessageService.addMessage(createdMessage);
        listMessage.add(createdMessage);

        Optional<List<Message>> optionalFoundedListMessage = ofNullable(iMessageService.getAllMessage());
        optionalFoundedListMessage.ifPresent(messages -> assertEquals(listMessage, optionalFoundedListMessage.get(), "list not equals"));
    }

    @Test
    void getMessageByIdTest() {

        Message createdMessage = new Message();
        createdMessage.setId(1L);
        createdMessage.setContent("test msg");
        createdMessage.setSenderName("test user");
        createdMessage.setBlob(new byte[] {1,2,3});
        createdMessage.setTimestamp(new Date(1111111));
        iMessageService.addMessage(createdMessage);

        Optional<Message> messageById = ofNullable(iMessageService.getMessageById(createdMessage.getId()));
        messageById.ifPresent(message -> assertEquals(createdMessage, messageById.get()));

    }
//    @Test
//    void getMessageByIdTest() {//этот метод сравнивает Optional.empty c Optional.empty поэтому true, конечно.
//
//        Optional<Message> optionalGetMessageById = Optional.ofNullable(iMessageService.findMessageById(1L));
//        optionalGetMessageById.ifPresent(message -> {
//            message.setId(1L);
//            message.setContent("ms");
//            message.setSenderName("ur");
//            message.setBlob(new byte[]{11, 22});
//            message.setTimestamp(new Date(2222222L));
//            iMessageService.addMessage(message);
//        });
//
//        Optional<Message> optionalFoundedMessage = Optional.ofNullable(iMessageService.getMessageById(optionalGetMessageById.get().getId()));
//        optionalFoundedMessage.ifPresent(message -> assertEquals(optionalGetMessageById, optionalFoundedMessage, "messages not equals"));
//    }

    @Test
    void deleteMessageByIdTest() {
        Message createdMessage = new Message();
        createdMessage.setId(1L);
        createdMessage.setContent("test msg");
        createdMessage.setSenderName("test user");
        createdMessage.setBlob(new byte[] {1,2,3});
        createdMessage.setTimestamp(new Date(1111111));
        iMessageService.addMessage(createdMessage);

        iMessageService.deleteMessageById(createdMessage.getId());
        assertEquals(null, iMessageService.findMessageById(createdMessage.getId()));
    }

//    @Test
//    void deleteMessageByIdTest() {
//        Optional<Message> optionalDeleteMessage = Optional.ofNullable(iMessageService.findMessageById(1L));
//        optionalDeleteMessage.ifPresent(message -> {
//            message.setId(1L);
//            message.setContent("ms");
//            message.setSenderName("ur");
//            message.setBlob(new byte[]{11, 22});
//            message.setTimestamp(new Date(2222222L));
////            iMessageService.deleteMessageById(1l);
//        });
//
//        assertEquals(Optional.empty(), optionalDeleteMessage, "messages not equals");
//    }

    @Test
    void editMessageTest() {
        Message createdMessage = new Message();
        createdMessage.setId(1L);
        createdMessage.setContent("test msg");
        createdMessage.setSenderName("test user");
        createdMessage.setBlob(new byte[] {1,2,3});
        createdMessage.setTimestamp(new Date(1111111));
        iMessageService.addMessage(createdMessage);

        Message editedMessage = iMessageService.findMessageById(createdMessage.getId());
        editedMessage.setContent("ms");
        editedMessage.setSenderName("ur");
        editedMessage.setBlob(new byte[] {11,22});
        editedMessage.setTimestamp(new Date(2222222));
        iMessageService.editMessage(editedMessage);

//        Optional<Message> optionalFoundedMessage = Optional.ofNullable(iMessageService.findMessageById(1L));
//        optionalFoundedMessage.ifPresent(message -> assertEquals(createdMessage, optionalFoundedMessage.get(),"messages not equals"));

        Optional<Message> optionalFoundedMessage = Optional.ofNullable(iMessageService.findMessageById(editedMessage.getId()));
        optionalFoundedMessage.ifPresent(message -> assertEquals(editedMessage, optionalFoundedMessage.get(),"messages not equals"));
      }

//    @Test
//    void editMessageTest() {
//
//        Optional<Message> optionalEditMessage = Optional.ofNullable(iMessageService.findMessageById(1L));
//        optionalEditMessage.ifPresent(message -> {
//            message.setId(1L);
//            message.setContent("ms");
//            message.setSenderName("ur");
//            message.setBlob(new byte[] {11,22});
//            message.setTimestamp(new Date(2222222L));
////            iMessageService.editMessage(message);
//        });
//
//        Optional<Message> optionalFoundedMessage = Optional.ofNullable(iMessageService.findMessageById(1L));
//        optionalFoundedMessage.ifPresent(message -> assertEquals(optionalEditMessage, optionalFoundedMessage,"messages not equals"));
//    }

//    @Test
//    void addMessageTest() {
//        Optional<Message> optionalAddMessage = Optional.ofNullable(iMessageService.findMessageById(1L));
//        optionalAddMessage.ifPresent(message -> {
//            message.setContent("test msg");
//            message.setSenderName("test user");
//            message.setBlob(new byte[]{1, 2, 3});
//            message.setTimestamp(new Date(1111111));
//            message.setId(1L);
//        });
//
//        Optional<Message> optionalFoundedMessage = Optional.ofNullable(iMessageService.findMessageById(1L));
//        optionalFoundedMessage.ifPresent(message ->  assertEquals(optionalAddMessage, optionalFoundedMessage));
//    }

    @Test
    void addMessageTest() {
        Message createdMessage = new Message();
        createdMessage.setContent("test msg");
        createdMessage.setSenderName("test user");
        createdMessage.setBlob(new byte[] {1,2,3});
        createdMessage.setTimestamp(new Date(1111111));
        createdMessage.setId(1L);

//        Optional<Message> createdMess = Optional.ofNullable(iMessageService.addMessage(createdMessage));
//        createdMess.ifPresent(message ->  assertEquals(1L, message.getId()));

        Optional<Message> createdMess = Optional.ofNullable(iMessageService.addMessage(createdMessage));
        createdMess.ifPresent(message -> assertEquals(createdMessage, createdMess.get(), "messages not equals"));
    }
}