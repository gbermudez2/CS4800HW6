import java.util.Date;

public class Memento {
    private final String content;
    private final Date timestamp;

    public Memento(String content, Date timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}