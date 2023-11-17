
/**
 * Represents a deck of cards. Every deck has 52 cards.
 * Every deck can be shuffled and dealt from.
 */
public class Deck {
    private Card[] cards;

    /**
     * Constructor for a deck of cards. Creates a deck of 52 cards.
     * The cards are ordered by suit and value.
     * The suits are ordered alphabetically (C, D, H, S).
     * The values are ordered by the order in which they appear in Card.VALUES.
     */
    public Deck() {
        cards = new Card[52];
        int index = 0;
        for (char suit : Card.SUITS) {
            for (String value : Card.VALUES) {
                cards[index] = new Card(suit, value);
                index++;
            }
        }
    }
}
