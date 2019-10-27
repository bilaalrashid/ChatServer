import com.google.gson.Gson;
import java.time.LocalDateTime;

/**
 * A message sent by a user
 */
class Message {

    // Properties

    /**
     * The name of the sender
     */
    private String name;

    /**
     * The date and time that the message was sent
     */
    private LocalDateTime timestamp;

    /**
     * The text being sent
     */
    private String text;

    // Constructor

    /**
     * Creates a new message
     * @param name The name of the sender
     * @param timestamp The date and time that the message was sent
     * @param text The text being sent
     */
    Message(String name, LocalDateTime timestamp, String text) {
        this.name = name;
        this.timestamp = timestamp;
        this.text = text;
    }

    // Name

    /**
     * Gets the name of the sender
     * @return The sender's name
     */
    String getName() {
        return this.name;
    }

    /**
     * Sets the name of the sender
     * @param name The sender's new name
     */
    void setName(String name) {
        this.name = name;
    }

    // Timestamp

    /**
     * Gets the date and time that the message was sent
     * @return The timestamp
     */
    LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    /**
     * Sets the date and time that the message was sent
     * @param timestamp The new timestamp
     */
    void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Text

    /**
     * Gets the text of the message
     * @return The text
     */
    String getText() {
        return this.text;
    }

    /**
     * Sets the text of the message
     * @param text The text
     */
    void setText(String text) {
        this.text = text;
    }

    // JSON

    /**
     * Converts the object to a JSON string
     * @return The JSON string
     */
    String toJsonString() {
        Gson g = new Gson();
        return g.toJson(this);
    }

    /**
     * Creates a Message from a JSON string
     * @param json The JSON string
     * @return The new Message object
     */
    static Message fromJsonString(String json) {
        Gson g = new Gson();
        return g.fromJson(json, Message.class);
    }

}
