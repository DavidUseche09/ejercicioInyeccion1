import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("textMessageService")
public class TextMessageService implements MessageService {
    @Autowired
    @Override
    public String sendMessage(String recipient, String message) {
        // Lógica para enviar un mensaje de texto
        return "Enviando mensaje de texto a " + recipient + ": " + message;
    }
}
