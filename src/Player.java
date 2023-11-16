public class Player {
	private Account account; 
	private int funds; 
	private int bets; 
	private Score score; 
	private Hand hand; 
	
	public Player()
	{
		// set funds available in the beginning of the game
		funds = 1000;  
		
		// declare a set of Hand class
		hand = new Hand(); 
		
	}
	
	// to check how much available funds the player have
	
	public int getFunds()
	{
		return this.funds; 
	}
	
	// if the player wins, but not BlackJack, they get to keep their bets 
	// Bets will restart to 0
	
	public void playerWins()
	{
		funds += bets; 
		bets = 0; 
	}
	
	// if the player blackjacks, they get to keep their bet times 1.5 
	// Bets will restart 0 after 
	
	public void playerBlackJacks()
	{
		funds += bets * 1.5;
		bets = 0; 
	}
	
	// if player bust, they will lose their bet
	// Bets will restart to 0 
	
	public void playerLost()
	{
		funds -= bets; 
		bets = 0; 
	}
	
	// setters and getters of bets 
	// We set up the game to have a minimum bet of 10 
	
	public void setBet(int b)
	{
		if (b >= 10)
		{
			this.bets = b;
		}
		else 
		{
			System.out.println("Minimum Bet: $10");
		}
	}
	public int getBet()
	{
		return this.bets;
	}
	
	// at the end of the game, we clear each player's hands 
	
	public void clearHand()
	{
		hand.clear(); 
	}
	public int calculatedHand()
	{
		return hand.getHandTotal(); 
	}
	
	public Account getName()
	{
		return this.getName(); 
	}
	
	public String toString()
	{
		return "Player: " + account.getName() + "\n" + "Balance: " + this.funds; 
	}
}
