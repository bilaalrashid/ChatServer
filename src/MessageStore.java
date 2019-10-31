import java.util.ArrayList;
import java.util.List;

/**
 * Singleton store for all messages to the server
 */
class MessageStore {

    // Singleton configuration

    /**
     * Private lazily loaded instance
     */
    private static MessageStore instance;

    /**
     * Private constructor for singleton
     */
    private MessageStore() {}

    /**
     * Gets the shared instance
     * @return The shared singleton instance
     */
    public static MessageStore getInstance() {
        if (instance == null) {
            // Synchronized to add thread safety
            synchronized (MessageStore.class) {
                if(instance==null) {
                    // if instance is null, initialize
                    instance = new MessageStore();
                }
            }
        }

        return instance;
    }

    // Instance configuration

    /**
     * All of the sent messages
     */
    private ArrayList<Message> messages = new ArrayList<Message>();

    /**
     * Adds a message to the store
     * @param message The message to add
     * @return The ID of the newly stored message
     */
    int addMessage(Message message) {
        this.messages.add(message);

        return this.messages.size() - 1;
    }

    /**
     * Determines if there are any new messages since a message
     * @param id The ID of the message to check after
     * @return If there are any new messages
     */
    boolean areNewMessageAvailableSinceId(int id) {
        return (this.messages.size() == id + 1);
    }

    /**
     * Gets any new messages since a particular message
     * @param id The ID of the message to check after
     * @return The new messages
     */
    Message[] getNewMessagesSinceId(int id) {
        if (this.messages.size() == id + 1) {
            return new Message[0];
        }

        List<Message> sublist = this.messages.subList(id + 1, this.messages.size());

        return sublist.stream().toArray(Message[] ::new);
    }

}
