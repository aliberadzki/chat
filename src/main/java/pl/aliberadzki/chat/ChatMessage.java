package pl.aliberadzki.chat;


import org.springframework.data.annotation.Id;

/**
 * Created by aliberadzki on 29.05.17.
 */
public class ChatMessage {

    @Id
    private String id;

    private String content;
    private String author;
    private String topic;
    private String timestamp;

    public ChatMessage() {
    }

    public ChatMessage(String content) {
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
