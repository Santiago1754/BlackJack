import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

	private Game game;
    private Player player1;
    private Player player2;
    private Dealer dealer;
    private Scoreboard scoreboard;
    private Deck[] decks;
	
	@BeforeEach
	void setUP() {
		player1 = new Player();
        player2 = new Player();
        dealer = new Dealer();
        scoreboard = new Scoreboard(new Score[]{});
        decks = new Deck[]{new Deck(), new Deck()};

        Player[] players = {player1, player2};

        game = new Game("TestGame", players, dealer, scoreboard, decks);
	}
	
	@Test
	void testMethods() {
		
		assertEquals("TestGame", game.getId());
		assertArrayEquals(new Player[] {player1, player2}, game.getPlayers());
		assertEquals(dealer, game.getDealer());
		assertEquals(scoreboard, game.getScoreboard());
		assertArrayEquals(decks, game.getDecks());
	}
	
	@Test
	void testHasDealer() {
		assertTrue(game.hasDealer());
		game.setDealer(null);
		assertFalse(game.hasDealer());
	}
	
	@Test
	void testAddPlayer() {
		Player newPlayer = new Player();
		game.addPlayer(newPlayer);
		
		Player[] expected = {player1, player2, newPlayer};
		assertArrayEquals(expected, game.getPlayers());
	}
	
//	@Test
//	void testRemovePlayer() {
//		game.removePlayer(player1.getName());
//		
//		Player[] expected = {player1, player2, newPlayer};
//		assertArrayEquals(expected, game.getPlayers());
//	}
	
}
