package com.example.ejercicioDependencias1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/message")
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/sendText")
    public ResponseEntity<String> sendTextMessage(@RequestBody Message message) {
        messageService.sendTextMessage(message);
        return ResponseEntity.ok("Mensaje de texto enviado con éxito");
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmailMessage(@RequestBody Message message) {
        messageService.sendEmailMessage(message);
        return ResponseEntity.ok("Correo electrónico enviado con éxito");
    }

    @GetMapping()
    public List<Message> showMessage(){
        List<Message> result = messageService.showMessages();
        return result;
    }

}

















//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/messages")
//public class com.example.ejercicioDependencias1.MessageController {
//    private final IMessageService textMessageService;
//    private final IMessageService emailMessageService;
//
//    @Autowired
//    public com.example.ejercicioDependencias1.MessageController(@Qualifier("textMessageService") IMessageService textMessageService,
//                             @Qualifier("emailMessageService") IMessageService emailMessageService) {
//        this.textMessageService = textMessageService;
//        this.emailMessageService = emailMessageService;
//    }
//
//    @PostMapping("/sendText")
//    public String sendTextMessage(@RequestBody() String recipient, String message) {
//        String whatever = textMessageService.sendMessage(recipient, message);
//        return whatever;
//    }
//
//    @PostMapping("/sendEmail")
//    public ResponseEntity<String> sendEmailMessage(@RequestBody() String recipient, String message) {
//        emailMessageService.sendMessage(recipient, message);
//        return ResponseEntity.ok("Correo electrónico enviado con éxito");
//    }
//}
