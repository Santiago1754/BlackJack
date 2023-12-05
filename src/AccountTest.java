import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	public void testToSetName() {
		Account account = new Account("");
		String nom = "Erika"; 
		account.setName(nom);
		assertEquals(account.getUserID(),nom); 		
	}
	@Test 
	public void testToIsPlayer() 
	{
		Account account = new Account(""); 
		account.setRole("Player");
		assertTrue(account.isPlayer());
		assertFalse(account.isDealer());
	}
	@Test
	public void testToIsDealer() 
	{
		Account account = new Account(""); 
		account.setRole("Dealer");
		assertTrue(account.isDealer());
		assertFalse(account.isPlayer());
	}
}
