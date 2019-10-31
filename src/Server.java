import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A server
 */
class Server {

    // Properties

    /**
     * The server socket
     */
    private ServerSocket serverSocket;

    // Constructor

    /**
     * Creates a new server
     * @param port The port to listen and serve on
     * @throws IOException Error setting up socket streams
     */
    Server(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        this.serverSocket = serverSocket;
    }

    // Public methods

    /**
     * Listens for new clients and runs client handlers
     * @throws IOException Connection error
     */
    void listenForClients() throws IOException {
        Socket clientSocket = this.serverSocket.accept();

        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

        Thread thread = new ClientHandler(clientSocket, dis, dos);

        thread.start();
    }

}
