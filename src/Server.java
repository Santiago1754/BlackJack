import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            // Get IP address of the server
            InetAddress serverAddress = InetAddress.getLocalHost();
            String serverIP = serverAddress.getHostAddress().trim();
            System.out.println("Server IP: " + serverIP);
            System.out.println("Blackjack Server is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Create a new thread to handle the client
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                ObjectInputStream objectIn = new ObjectInputStream(inputStream);
                // TODO - TEMPORARY HANDLING OF CLIENT MESSAGE
                // TODO - REPLACE WITH GAME LOGIC
                try {
                    Message message = (Message) objectIn.readObject();
                    System.out.println("Message received from client: " + message);
                } catch (ClassNotFoundException e) {
                    System.out.println("Error reading message from client");
                    e.printStackTrace();
                }

            } catch (IOException e) {
                System.out.println("Error handling client");
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}