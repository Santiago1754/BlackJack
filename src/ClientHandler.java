
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // Handle communication with the client in this thread
        // For example, you can create a Blackjack game instance for each client
        // and handle the game logic in a separate thread.
        try {
            // Code that may throw IOException
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}