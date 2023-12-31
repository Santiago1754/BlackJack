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
		account = new Account(""); 
		
	}
	
	// to check how much available funds the player have
	
	public int getFunds()
	{
		return this.funds; 
	}

	/**
	 * Returns the account associated with the player.
	 * 
	 * @return the account associated with the player
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * Sets the account associated with the player.
	 * 
	 * @param account the account to be set
	 */
	public void setAccount(Account account) {
		this.account = account;
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
		hand.clearHand(); 
	}
	public int calculatedHand()
	{
		return hand.getHandTotal(); 
	}
	
	public String getName()
	{
		return this.account.getUserID(); 
	}
	
	public String toString()
	{
		return "Player: " + this.getName() + "\n" + "Balance: " + this.funds; 
	}
}
