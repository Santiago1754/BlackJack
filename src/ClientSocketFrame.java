import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientSocketFrame extends JFrame implements ActionListener  {
    JLabel userLabel, socketLabel;
    JLabel passwordLabel, role, roleChose;
    JLabel loginMessage, errorMessage;
    JTextField userTextField;
    JPasswordField passTextField;
    JTextField txtMark;
    JButton loginButton, createAccountButton, playerButton, dealerButton;
    JButton hitButton, standButton; 
    Account account = new Account(); 
    
   
   
    public ClientSocketFrame() {
    	
        this.setTitle("BlackJack Login");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        socketLabel = new JLabel(""); 
        socketLabel.setBounds(10, 20, 400, 25);
        add(socketLabel); 

        userLabel = new JLabel("User ID");
        userLabel.setBounds(10, 20, 80, 25);
        add(userLabel);
		
        userTextField = new JTextField();
        userTextField.setBounds(100, 20, 165, 25);
        add(userTextField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        add(passwordLabel);
        
		passTextField = new JPasswordField();
        passTextField.setBounds(100, 50, 165, 25);
        add(passTextField);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(20, 120, 100, 25);
        loginButton.addActionListener(this);
        add(loginButton);
        
        createAccountButton = new JButton("REGISTER"); 
        createAccountButton.setBounds(160, 120, 100, 25);
        createAccountButton.addActionListener(this);
        add(createAccountButton); 
        
        
		loginMessage = new JLabel(""); 
		loginMessage.setBounds(10,200,300,25); 
		add(loginMessage); 
		
		errorMessage = new JLabel(""); 
		errorMessage.setBounds(10,220,400,25);
		add(errorMessage); 

		/*------------------------------------------------------------------------*/
		
		
		 role = new JLabel("PICK A ROLE"); 
	     role.setBounds(10,50,80,25);
	     
	     playerButton = new JButton("PLAYER");
	     playerButton.setBounds(100, 50, 165, 25);
	     playerButton.addActionListener(this); 
	       
	     dealerButton = new JButton("DEALER");
	     dealerButton.setBounds(100, 80, 165, 25);
	     dealerButton.addActionListener(this); 
	     
	     roleChose = new JLabel("");
	     //roleChose.setBounds(10, 80, 165, 25);
	     
	     
	     /*------------------------------------------------------------------------*/
	     
	     hitButton = new JButton("HIT"); 
	     hitButton.setBounds(150, 20, 80, 25);
	     hitButton.addActionListener(this);
	     
	     standButton = new JButton("STAND"); 
	     standButton.setBounds(250, 20, 80, 25);
	     standButton.addActionListener(this);
	     
	        
			
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ClientSocketFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	Socket s;
		try {
			s = new Socket("localhost", 5000);
			socketLabel.setText(s.toString());
			if (e.getSource().equals(loginButton)) {
	            try {
	                int l = processInformation(s); 
	                
	                if (l == 1)
	                {
	                	errorMessage.setText("Happy Gaming");
	                	dispose();
	                	MainFrame(); 
	                }
	                else 
	                {
	                	errorMessage.setText("User and PassWord did not match. Try again!");
	                }
	                               
	                s.close(); 
	            } catch (UnknownHostException e1) {
	                e1.printStackTrace();
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	        else if (e.getSource().equals(createAccountButton)) {
	        	try {
	        		// Socket s = new Socket("localhost", 5000);
	                int c = createAccount(s);
	                
	                if (c == 0)
	                {
	                	// meaning user is already taken 
	                	errorMessage.setText("");
	                	loginMessage.setText("User already taken");
	                }
	                else 
	                {
	                	errorMessage.setText("");
	                	loginMessage.setText("You can login now!");
	                }
	                
	                //s.close(); 
	            } catch (UnknownHostException e1) {
	                e1.printStackTrace();
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	        
	        else if (e.getSource().equals(dealerButton))
	        {
	        	playerButton.hide();
	        	dealerButton.hide();
	        	roleChose.setBounds(10, 20, 165, 25);
	        	// roleChose.setText("I AM A DEALER");
				dealerPlays(s); 
	        }
	        else if (e.getSource().equals(playerButton))
	        {
	        	playerButton.hide();
	        	dealerButton.hide();
	        	roleChose.setBounds(10, 20, 165, 25);
	        	// roleChose.setText("I AM A PLAYER");
				playerPlays(s); 
	        }
		} catch (IOException | ClassNotFoundException e1) 
		
		{
			e1.printStackTrace();
		}
    }

    
	

	public int processInformation(Socket s) throws UnknownHostException, IOException {
        
		try 
		{
		
			// Socket s = new Socket("localhost", 5000);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

			String userName = userTextField.getText();
			String passWord = passTextField.getText(); 
			String combo = userName + " " + passWord; 
			account.setName(userName.toUpperCase());
			
			Message m1, m2; 
			m1 = new Message("LOGIN", "", combo); 
			
			while (true)
			{
				if (m1.getType().contains("LOGIN"))
				{
					oos.writeObject(m1); 
					oos.flush(); 
					
					m2 = (Message)ois.readObject(); 
					
					if (m2.getStatus().contains("Good"))
					{
						loginMessage.setText("You are ready"); 
						return 1; 
					}
					else if (m2.getStatus().contains("Bad"))
					{
						loginMessage.setText("You are not ready, Try Again!"); 
						return 0; 
					}
					else
					{
						loginMessage.setText("Error on getting message"); 
						break; 
					}
				}
			
			}
			oos.close();
			ois.close();
			
			
		} 
		catch (Exception e) 
		{
				e.printStackTrace(); 
		}
		return 0;	
    }
    
    public int createAccount(Socket s) throws UnknownHostException, IOException {
    	
    	try 
		{
		
			// Socket s = new Socket("localhost", 5000);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

			String userName = userTextField.getText();
			String passWord = passTextField.getText(); 
			String combo = userName + " " + passWord; 
			
			Message m1, m2; 
			m1 = new Message("REGISTER", "", combo); 
			
			
			oos.writeObject(m1); 
			oos.flush(); 
					
			m2 = (Message)ois.readObject(); 
					
			if (m2.getStatus().contains("Good"))
			{
				loginMessage.setText("You can now login"); 
				return 1; 
			}
			else if (m2.getStatus().contains("Bad"))
			{
				loginMessage.setText("User already taken");
				return 0; 
			}
			else
			{
				loginMessage.setText("Error on getting message");
			}
		
			oos.close();
			ois.close();
			
		} 
		catch (Exception e) 
		{
				e.printStackTrace(); 
		}
		return 0;	
    }
    
    public void MainFrame() 
    {
    	//Message messageToServer = new Message("");
    	this.setTitle("BlackJack Main");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        userLabel.hide();
        userTextField.hide();
        passwordLabel.hide();
		passTextField.hide();
        loginButton.hide();
        createAccountButton.hide(); 
		loginMessage.hide();
		errorMessage.hide();
		
		add(role);
		add(playerButton);
		add(dealerButton);
		add(roleChose); 

        this.setVisible(true);
    	
    }
    
    public void dealerPlays(Socket s) throws IOException, ClassNotFoundException 
    {
		// Game gameTest1 = new Game(); 
    	ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

    	Message message = new Message("ROLE", "DEALER", "");
    	Message messageFromServer; 
  
    	oos.writeObject(message); 
		oos.flush();
		
		messageFromServer = (Message)ois.readObject(); 
		
		if (messageFromServer.getType().contains("BAD"))
		{
			role.setText("Sorry! The game currently has a dealer. You are now a " + messageFromServer.getStatus());
			account.setRole(messageFromServer.getStatus());
			roleChose.setText(account.getName() + "IS A " + account.getRole()); 
		}
		
		else 
		{
			role.hide();
			roleChose.setText(account.getName() + " IS A " + messageFromServer.getStatus());
		}	
	}
    
    public void playerPlays(Socket s) throws IOException, ClassNotFoundException 
    {
    	
    	ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

    	Message message = new Message("ROLE", "PLAYER", "");
    	Message messageFromServer; 
  
    	oos.writeObject(message); 
		oos.flush();
		
		messageFromServer = (Message)ois.readObject(); 
		
		account.setRole(messageFromServer.getStatus());
		role.hide();
		socketLabel.hide();
		roleChose.setText(account.getName() + " IS A " + account.getRole());
		
		
		add(hitButton);
		add(standButton);
	
	}
    
}