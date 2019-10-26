import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A server
 */
class Server {

    // Properties

    /**
     * The input channel of the server
     */
    private BufferedReader serverInput;

    /**
     * The output channel of the server
     */
    private PrintWriter serverOutput;

    /**
     * The current line of input into the server
     */
    private String currentInput = null;

    // Constructor

    /**
     * Creates a new server
     * @param port The port to listen and serve on
     * @throws IOException Error setting up socket streams
     */
    Server(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();

        this.serverInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.serverOutput = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    // Send

    /**
     * Sends a message to the client
     * @param message The message to send
     */
    void sendMessage(String message) {
        this.serverOutput.println(message);
    }

    // Receive

    /**
     * Is the server currently receiving data from the client
     * @return If the server is currently receiving data
     * @throws IOException Error receiving input
     */
    boolean isReceiving() throws IOException {
        return (this.currentInput = this.serverInput.readLine()) != null;
    }

    /**
     * Gets the message being send to the server
     * @return The received message
     * @throws IOException Error receiving input
     */
    String getMessage() throws IOException {
        if (this.currentInput != null) {
            return this.currentInput;
        }

        throw new IOException("No input received");
    }

}
