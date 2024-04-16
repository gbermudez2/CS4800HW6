import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class History implements IterableByUser {
    private final List<Message> messages = new ArrayList<>();

    public void addMessage(Message message) {
        messages.add(message);
    }

    public Message getLastMessage() {
        if (messages.isEmpty()) {
            return null;
        }
        return messages.get(messages.size() - 1);
    }

    // IterableByUser interface
    @Override
    public Iterator iterator(User userToSearchWith) {
        return (Iterator) new SearchMessagesByUser(userToSearchWith, messages);
    }
}