import java.util.Random;

/**
 * Represents a deck of cards. Every deck has 52 cards.
 * Every deck can be shuffled and dealt from.
 */
public class Deck {
    private Card[] cards;
    private int currentDeckSize;

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
                currentDeckSize++;
            }
        }
    }

    /**
     * @return the number of cards currently in the deck
     */
    public int getCurrentDeckSize() {
        return currentDeckSize;
    }

    /**
     * Shuffles all the cards in the deck.
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }


    /**
     * Deals a card from the deck.
     * @return the card dealt from the deck
     */
    public Card deal() {
        if (currentDeckSize == 0) {
            return null;
        }
        currentDeckSize--;
        return cards[currentDeckSize];
    }

    /**
     * @return the number of cards left in the deck followed by a dash and the cards left in the deck separated by commas.
     */
    @Override
    public String toString() {
        String result = Integer.toString(currentDeckSize) + "-";

        for (int i = 0; i < currentDeckSize; i++) {
            result += cards[i];
            // Append a comma as long as it is not the last number
            if (i != currentDeckSize - 1) {
                result += ",";
            }
        }
        return result;
    }
}
