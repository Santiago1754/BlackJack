import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.*;
import java.awt.event.*;

public class Client {
    public static void main(String[] args) throws IOException {
        final int PORT = 5000;
        String serverIP = "localhost";
        // Ask the user for IP to connect to
        serverIP = JOptionPane.showInputDialog("Enter IP address to connect to: ");

        // Create a socket to connect to the server
        Socket socket = new Socket(serverIP, PORT);
        System.out.println("Connected to server: " + serverIP + ":" + PORT);

        // Get input and output streams
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // Show the login window
        JFrame loginFrame = new JFrame("BLACKJACK LOGIN");
        loginFrame.setSize(300, 300);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a panel to the frame
        JPanel loginPanel = new JPanel();
        loginFrame.add(loginPanel);

        // Add login and password input fields to the panel
        loginPanel.setLayout(null);
        JLabel userLabel = new JLabel("User ID");
        userLabel.setBounds(10, 20, 80, 25);
        loginPanel.add(userLabel);
        JTextField userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        loginPanel.add(userText);
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(10, 50, 80, 25);
        loginPanel.add(passLabel);
        JPasswordField passText = new JPasswordField();
        passText.setBounds(100, 50, 165, 25);
        loginPanel.add(passText);

        // Add login and register buttons to the panel
        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(10, 80, 80, 25);
        loginPanel.add(loginButton);
        JButton registerButton = new JButton("REGISTER");
        registerButton.setBounds(100, 80, 100, 25);
        loginPanel.add(registerButton);

        // Make frame visible
        loginFrame.setVisible(true);

        // Add action listeners to the buttons
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message response = null;
                String username = userText.getText();
                String password = passText.getText();
                Message message = new Message("LOGIN", "SENT", username + "\n" + password);
                try {
                    response = sendMessage(inputStream, outputStream, message);
                } catch (ClassNotFoundException | IOException e1) {
                    e1.printStackTrace();
                }
                System.out.println(response);

            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message response = null;
                String username = userText.getText();
                String password = passText.getText();
                Message message = new Message("REGISTER", "SENT", username + "\n" + password);
                try {
                    response = sendMessage(inputStream, outputStream, message);
                } catch (ClassNotFoundException | IOException e1) {
                    e1.printStackTrace();
                }

                if (response.getType().equals("REGISTER") && response.getStatus().equals("SUCCESS")) {
                    JOptionPane.showMessageDialog(loginFrame, "Account created successfully");
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Account creation failed");
                }

            }
        });

        socket.close();
    }

    /**
     * Sends a message to the server and returns the response
     * 
     * @param in      InputStream
     * @param out     OutputStream
     * @param message Message to send
     * @return Response from server
     */
    private static Message sendMessage(InputStream in, OutputStream out, Message message)
            throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOut = new ObjectOutputStream(out);
        objectOut.writeObject(message);
        objectOut.flush();
        ObjectInputStream objectIn = new ObjectInputStream(in);
        return (Message) objectIn.readObject();
    }

    private static void runMainMenu(InputStream inputStream, OutputStream outputStream) {
        System.out.println("TEST");
    }
}
