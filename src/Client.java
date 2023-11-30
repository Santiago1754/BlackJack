import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        final int PORT = 5000;
        // Ask the user for IP to connect to
        System.out.print("Enter IP address to connect to: ");
        Scanner scanner = new Scanner(System.in);
        String serverIP = scanner.nextLine();

        // Create a socket to connect to the server
        Socket socket = new Socket(serverIP, PORT);
        System.out.println("Connected to server: " + serverIP + ":" + PORT);

        // Get input and output streams
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        ObjectOutputStream objectOut = new ObjectOutputStream(outputStream);

        // TODO - TEMPORARY HANDLING OF CLIENT MESSAGE
        // TODO - REPLACE WITH GAME LOGIC
        objectOut.writeObject(new Message("HELLO", "SENT", "Hello from client!"));
    }

}