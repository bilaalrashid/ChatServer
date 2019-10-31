/**
 * Handles sent and received messages
 */
class MessageHandler {

    // Properties

    /**
     * The ID of the last handled message
     */
    private int lastId = 0;

    // Public methods

    /**
     * If the server should send a response to the client
     * @return If the server should send a response
     */
    boolean shouldSendResponse() {
        return MessageStore.getInstance().areNewMessageAvailableSinceId(this.lastId);
    }

    /**
     * Gets the responses to send to the client
     * @return The responses to send
     */
    String[] getResponses() {
        Message[] messages = MessageStore.getInstance().getNewMessagesSinceId(this.lastId);

        String[] responses = new String[messages.length];

        for (int i = 0; i < messages.length; i++) {
            responses[i] = messages[i].toJsonString();
        }

        return responses;
    }

    /**
     * Handles an incoming message
     * @param text The message
     */
    void handleMessage(String text) {
        Message message = Message.fromJsonString(text);
        int id = MessageStore.getInstance().addMessage(message);

        this.lastId = id;

        Console.write(message);
    }

}
