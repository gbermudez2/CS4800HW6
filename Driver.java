import java.util.Arrays;
import java.util.Collections;

public class Driver {
    public static void main(String[] args) {
        Server chatServer = new Server();

        User alice = new User("Alice", chatServer);
        User bob = new User("Bob", chatServer);

        chatServer.registerUser(alice);
        chatServer.registerUser(bob);

        alice.sendMessage(Arrays.asList("Bob"), "hi bob");
        bob.sendMessage(Collections.singletonList("Alice"), "hey alice!");
        alice.undoLastMessage();
        alice.sendMessage(Collections.singletonList("Bob"), "<<BLOCKED>>");
        bob.undoLastMessage();
        bob.undoLastMessage();

        for (Message message : alice) {
            System.out.println("Alice: " + message.getContent());
        }

        for (Message message : bob) {
            System.out.println("Bob: " + message.getContent());
        }
    }
}
