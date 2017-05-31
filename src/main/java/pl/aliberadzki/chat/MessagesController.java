package pl.aliberadzki.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

/**
 * Created by aliberadzki on 29.05.17.
 */
@Controller
@Deprecated
public class MessagesController {

    protected final Logger log = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ChatMessage ping(ChatMessage message){
        message.setTimestamp(LocalDateTime.now().toString());
        chatMessageRepository.save(message);
        log.info("Insert {}", message);
        return message;
    }

}
