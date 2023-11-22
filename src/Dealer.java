public class Dealer 
{
	private Hand hand; 
	
	public Dealer()
	{
		hand = new Hand(); 
	}
	

	// check if the dealer hit blackjack 

	public boolean isBlackJack()
	{
		if (hand.getHandTotal() == 21)
		{
			return true; 
		}
		else {
			return false; 
		}
	}

	// adds a card to the dealer's hand 

	public void addCard(Card card)
	{
		hand.addCardToHand(card); 
	}

	// calculates the hand of the dealer 

	public int calculateHand() 
	{
		return hand.getHandTotal(); 
	}
	
	// Clears the dealer's hand

	public void clearHand() {
		hand.clearHand; 
	}


	public void dealerPlays() 
	{
		while (hand.getHandTotal() <= 16)
		{
			hand.addCard()
		}
	}


}
