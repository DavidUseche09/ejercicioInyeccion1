import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("messages")
public class MessageController {
    private final MessageService textMessageService;
    private final MessageService emailMessageService;

    @Autowired
    public MessageController(@Qualifier("textMessageService") MessageService textMessageService,
                             @Qualifier("emailMessageService") MessageService emailMessageService) {
        this.textMessageService = textMessageService;
        this.emailMessageService = emailMessageService;
    }

    @PostMapping("/sendText")
    public String sendTextMessage(@RequestBody() String recipient, @RequestBody() String message) {
        String whatever = textMessageService.sendMessage(recipient, message);
        return whatever;
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmailMessage(@RequestBody() String recipient, @RequestBody() String message) {
        emailMessageService.sendMessage(recipient, message);
        return ResponseEntity.ok("Correo electrónico enviado con éxito");
    }
}
