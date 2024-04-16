import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchMessagesByUser implements Iterator<Message> {
    private final User userToSearchWith;
    private final List<Message> messages;
    private int index = 0;

    public SearchMessagesByUser(User userToSearchWith, List<Message> messages) {
        this.userToSearchWith = userToSearchWith;
        this.messages = messages;
    }

    @Override
    public boolean hasNext() {
        while (index < messages.size()) {
            Message message = messages.get(index);
            if (message.getSender().equals(userToSearchWith.getName()) || message.getRecipients().contains(userToSearchWith.getName())) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public Message next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Message message = messages.get(index);
        index++;
        return message;
    }
}
