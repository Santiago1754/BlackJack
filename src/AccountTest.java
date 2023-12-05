import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	public void test() {
		Account account = new Account("");
		String nom = "Erika"; 
		account.setName(nom);
		assertEquals(account.getUserID(),nom); 		
		
		
	}

}
