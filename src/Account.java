
public class Account {
	
	private String userID; 
	private String pass; 
	private String role; 
	
	public Account (String nom, String pw) {
		
		this.userID = nom; 
		this.pass = pw; 
	}
	public String getName() 
	{
		return this.userID; 
	}
	
	// in main, we can pick role
	public void setRole(String r)
	{
		this.role = r; 
	}
	public String getRole()
	{
		return this.role; 
	}	
}
