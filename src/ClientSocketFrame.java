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
    JLabel userLabel;
    JLabel passwordLabel, role, roleChose;
    JLabel loginMessage, errorMessage;
    JTextField userTextField;
    JPasswordField passTextField;
    JTextField txtMark;
    JButton loginButton, createAccountButton, playerButton, dealerButton;
    
   
   
    public ClientSocketFrame() {
        this.setTitle("BlackJack Login");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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
        loginButton.setBounds(10, 120, 200, 25);
        loginButton.addActionListener(this);
        add(loginButton);
        
        createAccountButton = new JButton("Create An Account"); 
        createAccountButton.setBounds(10, 140, 200, 25);
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
	     role.setBounds(10,20,80,25);
	     
	     playerButton = new JButton("PLAYER");
	     playerButton.setBounds(100, 20, 165, 25);
	     playerButton.addActionListener(this); 
	       
	     dealerButton = new JButton("DEALER");
	     dealerButton.setBounds(100, 50, 165, 25);
	     dealerButton.addActionListener(this); 
	     
	     roleChose = new JLabel("");
	     roleChose.setBounds(100, 80, 165, 25);
	     
	        
			
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
	        	roleChose.setBounds(100, 20, 165, 25);
	        	roleChose.setText("I AM A DEALER");
				dealerPlays(s); 
	        }
	        else if (e.getSource().equals(playerButton))
	        {
	        	playerButton.hide();
	        	dealerButton.hide();
	        	roleChose.setBounds(100, 20, 165, 25);
	        	roleChose.setText("I AM A PLAYER");
				playerPlays(s); 
	        }
		} catch (IOException e1) 
		
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
			
			Message m1, m2; 
			m1 = new Message("login", "", combo); 
			
			while (true)
			{
				if (m1.getType().contains("login"))
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
			m1 = new Message("create", "", combo); 
			
			
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
    	this.setTitle("BlackJack Main");
        this.setSize(1000, 1000);
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
    
    public void dealerPlays(Socket socket) 
    {
		Game gameTest1 = new Game(); 
		
	}
    
    public void playerPlays(Socket s) {
		
		
	}

    

	
}