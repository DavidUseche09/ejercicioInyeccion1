import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("emailMessageService")
public class EmailMessageService implements MessageService {
    @Autowired
    @Override
    public String sendMessage(String recipient, String message) {
        // Lógica para enviar un correo electrónico
        return "Enviando correo electrónico a " + recipient + ": " + message;
    }
}