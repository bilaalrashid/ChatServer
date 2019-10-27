import java.time.format.DateTimeFormatter;

/**
 * The output console
 */
class Console {

    /**
     * Writes text out to the console
     * @param text The text to write out
     */
    static void write(String text) {
        System.out.println(text);
    }

    /**
     * Displays a message in the console
     * @param message The message to be outputted
     */
    static void write(Message message) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        String formattedDateTime = message.getTimestamp().format(dateTimeFormatter);

        String output = String.format("%s [%s] %s", formattedDateTime, message.getName(), message.getText());
        System.out.println(output);
    }

}
