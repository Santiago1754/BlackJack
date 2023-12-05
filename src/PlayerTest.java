import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void testToSetBet() {
		Player player = new Player(); 
		player.setBet(20);
		assertEquals(player.getBet(), 20);
		
		// assertEquals(player.getBet(), 30);
	}
	
	@Test
	void testForPlayerBlackJack() {
		Player player = new Player(); 
		player.setBet(20);
		player.playerBlackJacks();
		assertEquals(player.getFunds(), 1030); 
	
	}
	
	@Test
	void testForPlayerLost()
	{
		Player player = new Player(); 
		player.setBet(20);
		player.playerLost();
		assertEquals(player.getFunds(), 980); 
	}
	@Test
	void testForToString()
	{
		Player player = new Player(); 
		Account account = new Account("");
		
		String nom = "Erika"; 
		account.setName(nom);
		System.out.println(player.toString());
		// assertEquals(player.toString(), "Player: Erika \nBalance: 1000");
	}
	
	
	
	
	

}
