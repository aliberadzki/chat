package pl.aliberadzki.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by aliberadzki on 30.05.17.
 */
@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {

    protected final Logger log = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @RequestMapping(path = "/{topicName}", method = RequestMethod.POST)
    public ChatMessage postMessage(@PathVariable("topicName") String topicName, @RequestBody ChatMessage chatMessage) {
        chatMessage.setTimestamp(LocalDateTime.now().toString());
        chatMessage.setTopic(topicName);
        chatMessageRepository.save(chatMessage);
        template.convertAndSend("/topic/" + topicName, chatMessage);
        log.info("Insert to {} {}", topicName, chatMessage);
        return chatMessage;
    }

    @RequestMapping(path = "/{topicName}", method = RequestMethod.GET)
    public List<ChatMessage> getMessages(@PathVariable("topicName") String topicName) {
        return chatMessageRepository.findByTopic(topicName);
    }
}
