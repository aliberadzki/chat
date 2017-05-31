package pl.aliberadzki.chat;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


/**
 * Created by aliberadzki on 30.05.17.
 */
public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

    List<ChatMessage> findByTopic(String topicName);
}
