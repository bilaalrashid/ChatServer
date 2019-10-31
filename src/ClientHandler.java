import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

/**
 * Handles the connection to an individual client
 */
class ClientHandler extends Thread {

    // Properties

    /**
     * The stream of input data
     */
    private final DataInputStream inputStream;

    /**
     * The stream of output data
     */
    private final DataOutputStream outputStream;

    /**
     * The connection socket
     */
    private final Socket socket;

    /**
     * The message handler
     */
    private MessageHandler messageHandler = new MessageHandler();

    // Constructor

    /**
     * Creates a new client handler
     * @param socket The stream of input data
     * @param inputStream The stream of output data
     * @param outputStream The connection socket
     */
    ClientHandler(Socket socket, DataInputStream inputStream, DataOutputStream outputStream) {
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    /**
     * Listens and sends messages to and from the client
     */
    @Override
    public void run() {
        while (true) {
            try {
                if (this.messageHandler.shouldSendResponse()) {
                    String[] responses = this.messageHandler.getResponses();

                    for (String response : responses) {
                        this.outputStream.writeUTF(response);
                    }
                }

                String input = inputStream.readUTF();

                if (input != null) {
                    this.messageHandler.handleMessage(input);
                }
            } catch (SocketException e) {
                try {
                    this.close();
                } catch (IOException io) {
                    Console.write("Connection error");
                }
            } catch (Exception e) {
                Console.write("Connection error");
            }
        }
    }

    /**
     * Closes connections to the client
     * @throws IOException Connection error
     */
    void close() throws IOException {
        this.socket.close();
        this.inputStream.close();
        this.outputStream.close();
    }

}
