package ws.eliseev.fitness.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ws.eliseev.fitness.model.Message;
import ws.eliseev.fitness.service.MessageService;

import java.util.List;

@Tag(name = "Message", description = "CRUD  операции над сообщениями в чатe")
//@RequiredArgsConstructor
@RestController
@RequestMapping("/chat/api_msg")
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/getall")
    private List<Message> allMessage() {
        return messageService.getAllMessage();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{id}")
    private Message getMessage(@PathVariable("id") Long id) {
        return messageService.getMessageById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping
    public void PutEditMsg(@RequestBody Message message) {
        messageService.editMessage(message);;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @DeleteMapping("/{id}")
    private void DeleteMsg(@PathVariable("id") Long id) {
        messageService.deleteMessageById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping
    public Message PostAddMsg(@RequestBody Message message) {
        return messageService.addMessage(message);
    }

}
