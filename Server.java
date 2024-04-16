import java.util.HashMap;
import java.util.Map;

public class Server {
    private final Map<String, User> users = new HashMap<>();

    public void registerUser(User user) {
        users.put(user.getName(), user);
    }

    public void unregisterUser(User user) {
        users.remove(user.getName());
    }

    public void sendMessage(Message message) {
        for (String recipient : message.getRecipients()) {
            User user = users.get(recipient);
            if (user != null) {
                user.receiveMessage(message);
            }
        }
    }

    public void blockUser(String userName, String blockedUser) {
        User user = users.get(userName);
        if (user != null) {
            user.blockUser(blockedUser);
        }
    }
}
