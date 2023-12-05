import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest{

	@Test
	void testToSetBet() {
		Player player = new Player(); 
		player.setBet(20);
		assertEquals(20,player.getBet());
	}
	
	@Test
	void testForPlayerBlackJack() {
		Player player = new Player(); 
		player.setBet(20);
		player.playerBlackJacks();
		assertEquals(1030,player.getFunds()); 
	}
	@Test
	void testForPlayerLost()
	{
		Player player = new Player(); 
		player.setBet(20);
		player.playerLost();
		assertEquals(980, player.getFunds()); 
	}
	//@Test
//	void testForToString()
//	{
//		Player player = new Player(); 
//		Account account = new Account("");
//		
//		String nom = "Erika"; 
//		account.setName(nom);
//		System.out.println(player.toString());
//		assertEquals("Player: Erika \nBalance: 1000", player.toString()); 
//	}
}
