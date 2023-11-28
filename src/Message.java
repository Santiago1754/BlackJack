/**
 * Message class for sending data between the server and client.
 * 
 * There are multiple types of messages. They are listed below:
 * TODO - ADD MESSAGE TYPES
 * 
 * The status of a message can be one of the following:
 * SENT - The message was sent successfully. The client sends this message to
 * the server.
 * ERROR - There was an error sending the message. The server sends this message
 * to the client.
 * SUCCESS - The message was received successfully. The server sends this
 * message to the client.
 * 
 * The data of a message is any text that the client or server should process.
 * This data depends on the type of message, as well as the status of the
 * message.
 */
public class Message {
    private String type;
    private String status;
    private String data;

    /**
     * Constructor for a message. Initializes the type, status, and data of the
     * message to "undefined".
     */
    public Message() {
        this.type = "undefined";
        this.status = "undefined";
        this.data = "undefined";
    }

    /**
     * Constructor for a message. Initializes the type, status, and data of the
     * message.
     * All parameters are initialized as per the above descriptions.
     * 
     * @param type   The type of message.
     * @param status The status of the message.
     * @param data   The data of the message.
     */
    public Message(String type, String status, String data) {
        this.type = type;
        this.status = status;
        this.data = data;
    }

    /**
     * Gets the type of the message.
     * 
     * @return The type of the message.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Gets the status of the message.
     * 
     * @return The status of the message.
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Gets the data of the message.
     * 
     * @return The data of the message.
     */
    public String getData() {
        return this.data;
    }

    /**
     * Sets the type of the message.
     * 
     * @param type The type of the message.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the status of the message.
     * 
     * @param status The status of the message.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Sets the data of the message.
     * 
     * @param data The data of the message.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Converts the message to a string in the following format:
     * TYPE: <type>
     * STATUS: <status>
     * DATA: <data>
     * 
     * @return The message as a string.
     */
    @Override
    public String toString() {
        return "TYPE: " + this.type + "\nSTATUS: " + this.status + "\nDATA: " + this.data;
    }
}
