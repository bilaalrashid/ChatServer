/**
 * The main interface for the server
 */
public class Main {

    /**
     * Gets the port to run the server on
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        if (args != null && args.length == 1) {
            int port = Integer.parseInt(args[0]);
        } else {
            System.out.println("Invalid arguments. Port not specified.");
        }
    }

}
