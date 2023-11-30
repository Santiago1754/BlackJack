import java.util.ArrayList;
import java.util.List;

public class Hand {

    // Private Variables
    private List<Card> cards;
    private int handTotal;

    // Constructor
    public Hand() {
        handTotal = 0;
        cards = new ArrayList<>();
    }

    // Get the latest card in the hand
    public Card getLatest() {
        return cards.get(cards.size() - 1);
    }

    // Set the total value of the hand
    public void setHandTotal(int handTotal) {
        this.handTotal = handTotal;
    }

    // Get the number of cards in the hand
    public int getNumCards() {
        return cards.size();
    }

    // Get the total value of the hand
    public int getHandTotal() {
        return handTotal;
    }

    // Add a card to the hand and update the hand's total value
    public void addCardToHand(Card card) {
      if (card.getValue().equals("1") && handTotal < 11) {
        // If the card is an Ace and its value as 11 won't bust, use 11
        handTotal += 11;
      } else if (Integer.parseInt(card.getValue()) > 10) {
        // If the card is a face card, use its value as 10
        handTotal += 10;
      } else {
        // Otherwise, use the numeric value of the card
        handTotal += Integer.parseInt(card.getValue());
      }

      // Add the card to the hand
      cards.add(card);
    }

    // Clear the hand of any cards
    public void clearHand() {
      cards.clear();
      handTotal = 0;
    }

    public Card accessCardAtIndex(int index) {
      return cards.get(index);
    }

    // Set the hand equal to another hand by copying its cards
    public void setEqualTo(Hand otherHand) {

      // Copy cards from the other hand to this hand
      for (int i = 0; i < otherHand.getNumCards(); i++) {
        addCardToHand(otherHand.accessCardAtIndex(i));
      }
    }
  }
