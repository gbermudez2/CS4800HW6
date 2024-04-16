// CS4800
// HW6
// Gabriel Bermudez

import java.util.Date;
import java.util.List;

public class Message {
    private final String sender;
    private final List<String> recipients;
    private Date timestamp;
    private String content;

    public Message(String sender, List<String> recipients, String content) {
        this.sender = sender;
        this.recipients = recipients;
        this.timestamp = new Date();
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    // Memento pattern
    public Memento saveToMemento() {
        return new Memento(content, timestamp);
    }

    public void restoreFromMemento(Memento memento) {
        this.content = memento.getContent();
        this.timestamp = memento.getTimestamp();
    }
}