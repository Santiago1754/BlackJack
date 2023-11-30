import java.io.*;
import java.net.Socket;

public class Client {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);

            // Create separate threads for reading and writing to the server
            Thread readerThread = new Thread(new ServerReader(socket));
            Thread writerThread = new Thread(new ServerWriter(socket));

            readerThread.start();
            writerThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ServerReader implements Runnable {
        private final Socket socket;

        public ServerReader(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Your server reading logic here
                InputStream inputStream = socket.getInputStream();
                // Read from inputStream

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    String data = new String(buffer, 0, bytesRead);
                    // Process the received data
                    System.out.println("Received data: " + data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ServerWriter implements Runnable {
        private final Socket socket;

        public ServerWriter(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Your server writing logic here
                OutputStream outputStream = socket.getOutputStream();
                // Write to outputStream
                
                String dataToWrite = "Your data to write";
                outputStream.write(dataToWrite.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}