import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket and bind it to a specific port
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server is waiting for client to connect...");

            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read and print messages from the client
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage;

            // Read messages from the client and send responses
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Client: " + clientMessage);

                // Read server's message from the console and send it to the client
                System.out.print("Server: ");
                String serverMessage = consoleInput.readLine();
                out.println(serverMessage);
            }

            // Close the connections
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}