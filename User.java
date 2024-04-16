import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;

public class User implements Iterable<Message>, IterableByUser {
    private final String name;
    private final Server chatServer;
    private final History chatHistory = new History();
    private final List<String> blockedUsers = new ArrayList<>();
    private Message lastSentMessage;

    public User(String name, Server chatServer) {
        this.name = name;
        this.chatServer = chatServer;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(List<String> recipients, String content) {
        Message message = new Message(name, recipients, content);
        chatHistory.addMessage(message);
        lastSentMessage = message;
        chatServer.sendMessage(message);
    }

    public void receiveMessage(Message message) {
        if (!blockedUsers.contains(message.getSender())) {
            System.out.println(name + " received message from " + message.getSender() + ": " + message.getContent());
        }
    }

    public void undoLastMessage() {
        if (lastSentMessage != null) {
            lastSentMessage.restoreFromMemento(lastSentMessage.saveToMemento());
            System.out.println(name + " deleted the last message.");
        } else {
            System.out.println(name + " has no messages to undo.");
        }
    }

    public void blockUser(String userName) {
        if (!blockedUsers.contains(userName)) {
            blockedUsers.add(userName);
            System.out.println(name + " blocked messages from " + userName);
        }
    }

    public History getChatHistory() {
        return chatHistory;
    }

    // Iterable interface
    @Override
    public Iterator<Message> iterator() {
        return chatHistory.iterator(this);
    }

    // IterableByUser interface
    @Override
    public Iterator iterator(User userToSearchWith) {
        return chatHistory.iterator(userToSearchWith);
    }
}
