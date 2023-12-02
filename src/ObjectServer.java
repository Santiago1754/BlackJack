import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

public class ObjectServer {

    public static void main(String[] argv) throws Exception {
       //  ServerSocket s = new ServerSocket(5000);
		
		try (var listener = new ServerSocket(5000))
		{
			System.out.println("Server started");
			var pool = Executors.newFixedThreadPool(5); 
			
			while (true)
			{
				pool.execute(new Handler(listener.accept())); 
			}
		}
	}
	public static class Handler implements Runnable {
	
		private Socket t; 
		
		Handler (Socket socket)
		{
			this.t = socket; 
		}
		
        public void run() 
		{
			try	
			{
			
				InputStream is = t.getInputStream();
				OutputStream os = t.getOutputStream();
				
				ObjectOutputStream oos = new ObjectOutputStream(os);
				ObjectInputStream ois = new ObjectInputStream(is); 
			
				while (true)
				{
					Message received = (Message) ois.readObject(); 
					if (received.getType().contains("login"))
					{
						Message updated = authenticate(received); 
						
						System.out.println(updated);
						oos.writeObject(updated); 
						oos.flush(); 
					}
					
					
					
					if (received.getType().contains("create"))
					{
						Message updated = createAcc(received); 
						oos.writeObject(updated); 
						oos.flush();
					}
					
					else
					{
						break; 
					}
				}
				
				ois.close();
				oos.close();
				t.close();
				
			} catch (IOException | ClassNotFoundException e)
			{
				e.printStackTrace(); 
			}
		}
    }
	
	private static Message authenticate(Message m) 
	{ 
		String[] combo = m.getData().split(" ");
		String user = combo[0];
		String password = combo[1];		
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
					m.setStatus("Good");
					return m;
				}
			}
			m.setStatus("Bad");
			buffer.close();
			
			return m; 
		}
		catch (FileNotFoundException error)
		{
			System.out.println("err");
			error.printStackTrace();
		} 
		
		catch (IOException e1) {
			e1.printStackTrace();
		}
		return m;
	}
	
	private static Message createAcc(Message m)
	
	{
		
		String[] combo = m.getData().split(" ");
		String user = combo[0];
		String password = combo[1];		
		String readData;
		String filename = "userList.txt"; 
		
		try (BufferedReader buffer = new BufferedReader(new FileReader(filename)))
		{			
			while ((readData = buffer.readLine()) != null)
			{
				String[] line = readData.split(" "); 
				System.out.println(line[0]);
				System.out.println(line[1]);
				
				if (line[0].equals(user))
				{
					m.setStatus("Bad");
					return m;
				}
			}
			
			BufferedWriter saved = new BufferedWriter(new FileWriter(filename, true)); 
			String newCombo = user + " " + password; 
			System.out.println(newCombo);
			saved.newLine();
			saved.write(newCombo);
			
			m.setStatus("Good");
			buffer.close();
			saved.close();
			
			return m; 
		}
		catch (FileNotFoundException error)
		{
			System.out.println("err");
			error.printStackTrace();
		} 
		
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return m; 
	}
}