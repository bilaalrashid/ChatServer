import java.io.IOException;

/**
 * The main interface for the server
 */
public class Main {

    /**
     * Runs a server on a specified port
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        if (args != null && args.length == 1) {
            int port = Integer.parseInt(args[0]);

            try {
                Server server = new Server(port);

                while (true) {
                    try {
                        server.listenForClients();
                    } catch (IOException e) {
                        Console.write("Error connecting to client");
                    }
                }
            } catch (IOException e) {
                Console.write("Server could not be started.");
            }
        } else {
            Console.write("Invalid arguments. Port not specified.");
        }
    }

}
