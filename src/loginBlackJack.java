import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class loginBlackJack implements ActionListener{
	
	private static JLabel userLabel; 
	private static JTextField userText; 
	private static JLabel passLabel; 
	private static JPasswordField passText; 
	private static JButton submit_Button; 
	private static JLabel success;
	private static JButton newUser_Button; 
	
	public static void main(String[] arg) {
		
		JFrame frame = new JFrame ("BLACKJACK LOGIN"); 
		JPanel panel = new JPanel(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		
		frame.add(panel);
		
		
		panel.setLayout(null);
		
		 
		userLabel = new JLabel("User ID");
		userLabel.setBounds(10,20,80,25);
		panel.add(userLabel); 
		
		userText = new JTextField(); 
		userText.setBounds(100,20,165,25);
		panel.add(userText);
		
		passLabel = new JLabel("Password");
		passLabel.setBounds(10,50,80,25);
		panel.add(passLabel); 
		
		passText = new JPasswordField(); 
		passText.setBounds(100,50,165,25);
		panel.add(passText);
		
		submit_Button = new JButton("LOGIN"); 
		submit_Button.setBounds(10,80,80,25);
		submit_Button.addActionListener(new loginBlackJack());
		panel.add(submit_Button); 
		
		success = new JLabel(" "); 
		success.setBounds(10,110,300,25);
		panel.add(success);
		
		newUser_Button = new JButton("CREATE AN ACCOUNT"); 
		newUser_Button.setBounds(10, 120, 157, 25);
		newUser_Button.addActionListener(new ActionListener()
		{
			public void actionPerformed (ActionEvent e)
			{
				createAccount(); 
			}
		});
		panel.add(newUser_Button); 

		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String user = userText.getText();
		String password = passText.getText(); 
		String readData;
		String filename = "userList.txt"; 
		
		try (BufferedReader buffer = new BufferedReader(new FileReader(filename)))
		{			
			while ((readData = buffer.readLine()) != null)
			{
				String[] line = readData.split(" "); 
				System.out.println(line[0]);
				System.out.println(line[1]);
				
				if (line[0].equals(user) && line[1].equals(password))
				{
					success.setText("Successfully logged in!");
					return;  
				}
			}
			success.setText("Unsuccessful login\n Try Again!");
			
			
			buffer.close();
			
			return; 
		}
		catch (FileNotFoundException error)
		{
			System.out.println("err");
			error.printStackTrace();
		} 
		
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void createAccount() {
		
	}
}
