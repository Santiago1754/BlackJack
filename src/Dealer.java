
/**
 * Represents the dealer in the Blackjack game.
 */
public class Dealer {

    private Account account;
    private Hand hand;

    /**
     * Constructs a new dealer with an empty hand.
     */
    public Dealer() {
        hand = new Hand();
    }

    /**
     * Returns the account associated with the dealer.
     *
     * @return the account associated with the dealer
     */
    public Account getAccount() {
        return account;
    }

    /**
	 * Sets the account associated with the dealer.
	 * 
	 * @param account the account to be set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

    /**
     * Checks if the dealer has a Blackjack.
     *
     * @return {@code true} if the dealer has a Blackjack, {@code false} otherwise.
     */
    public boolean isBlackJack() {
        return hand.getHandTotal() == 21;
    }

    /**
     * Adds a card to the dealer's hand.
     *
     * @param card The card to be added to the hand.
     */
    public void addCard(Card card) {
        hand.addCardToHand(card);
    }

    /**
     * Calculates the total value of the dealer's hand.
     *
     * @return The total value of the hand.
     */
    public int calculateHand() {
        return hand.getHandTotal();
    }

    /**
     * Clears the dealer's hand.
     */
    public void clearHand() {
        hand.clearHand();
    }

    /**
     * Simulates the dealer's turn in the game.
     * The dealer hits until their hand total is 17 or higher.
     */
    public void dealerPlays() {
        while (hand.getHandTotal() <= 16) {
            Card card = new Card(); // Create a new Card object
            hand.addCardToHand(card); // Pass the Card object to the addCardToHand() method
        }
    }
}
