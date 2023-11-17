package com.example.ejercicioDependencias1;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    List<Message> messages;

    public MessageService(){
        this.messages = new ArrayList<>();
    }

    public Message sendTextMessage(Message message) {
        this.messages.add(message);
        return message;
    }

    public Message sendEmailMessage(Message message) {
        this.messages.add(message);
        return message;
    }


}