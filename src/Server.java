import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
                Account account;

                // Get input and output streams
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();
                boolean connected = true;
                ObjectInputStream objectIn = new ObjectInputStream(inputStream);
                ObjectOutputStream objectOut = new ObjectOutputStream(outputStream);

                // Read messages from the client and send back responses
                while (connected) {
                    try {
                        Message message = (Message) objectIn.readObject();
                        // Handle login message
                        if (message.getType().equals("LOGIN")) {
                            System.out.println("Received LOGIN message from client");
                            System.out.println("Client IP: " + clientSocket.getInetAddress().getHostAddress());
                            File loginFile = new File("userList.txt");
                            if (!loginFile.exists()) {
                                loginFile.createNewFile();
                            }
                            Scanner loginScanner = new Scanner(loginFile);
                            // Check if the username and password match
                            while (loginScanner.hasNextLine()) {
                                String username = loginScanner.nextLine();
                                String password = loginScanner.nextLine();
                                String[] usernameCompare = message.getData().split("\n");
                                if (username.equals(usernameCompare[0]) && password.equals(usernameCompare[1])) {
                                    System.out.println("User " + username + " logged in");
                                    Message response = new Message("LOGIN", "SUCCESS", username);
                                    objectOut.writeObject(response);
                                    objectOut.flush();
                                    // Create a new Account object for the client
                                    account = new Account(username);
                                    break;
                                }
                            }

                            // If the username and password don't match, send a failure message
                            Message response = new Message("LOGIN", "ERROR", message.getData());
                            objectOut.writeObject(response);
                            objectOut.flush();

                            loginScanner.close();
                        } else if (message.getType().equals("REGISTER")) {
                            System.out.println("Received REGISTER message from client");
                            System.out.println("Client IP: " + clientSocket.getInetAddress().getHostAddress());
                            File loginFile = new File("userList.txt");
                            if (!loginFile.exists()) {
                                loginFile.createNewFile();
                            }
                            Scanner loginScanner = new Scanner(loginFile);
                            // Check if the username already exists
                            boolean usernameExists = false;
                            while (loginScanner.hasNextLine()) {
                                String username = loginScanner.nextLine();
                                String password = loginScanner.nextLine();
                                String[] usernameCompare = message.getData().split("\n");
                                if (username.equals(usernameCompare[0])) {
                                    usernameExists = true;
                                    break;
                                }
                            }

                            // If the username doesn't exist, add it to the file
                            if (!usernameExists) {
                                System.out.println("User " + message.getData() + " registered");
                                // Append the username and password to the file
                                FileWriter fileWriter = new FileWriter(loginFile, true);
                                fileWriter.write(message.getData() + "\n");
                                Message response = new Message("REGISTER", "SUCCESS", message.getData());
                                objectOut.writeObject(response);
                                objectOut.flush();
                                fileWriter.close();
                            } else {
                                Message response = new Message("REGISTER", "ERROR", message.getData());
                                objectOut.writeObject(response);
                                objectOut.flush();
                            }

                            loginScanner.close();
                        } else { // Return error message if the message type is not recognized
                            System.out.println("Received " + message.getType() + " message from client");
                            System.out.println("Client IP: " + clientSocket.getInetAddress().getHostAddress());
                            Message response = new Message("ERROR", "ERROR", message.getData());
                            objectOut.writeObject(response);
                            objectOut.flush();
                        }
                    } catch (ClassNotFoundException e) {
                        System.out.println("Error reading message from client");
                        e.printStackTrace();
                    }
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