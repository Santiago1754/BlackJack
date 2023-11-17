/**
 * The Card class represents a real-life playing card.
 * It contains two variables, suit and value.
 * 
 * Suit can take one of the following values:
 * - 'C' for clubs
 * - 'D' for diamonds
 * - 'H' for hearts
 * - 'S' for spades
 * 
 * Value can take the value of any number from 2 to 10, as well as:
 * - 'A' for aces
 * - 'J' for jacks
 * - 'Q' for queens
 * - 'K' for kings
 */
public class Card {
	private char suit;
	private String value;
	public static final char[] SUITS = {'C', 'D', 'H', 'S'};
	public static final String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
											"A", "J", "Q", "K"};
	
	/**
	 * The default constructor for the Card class.
	 * Sets both values to ones unusable in a game to signal an error.
	 */
	public Card() {
		this.suit = 'X';
		this.value = "X";
	}
	
	/**
	 * The primary constructor for the Card class.
	 * @param suit the suit of the card as a char
	 * @param value the value of the card as a String
	 */
	public Card(char suit, String value) {
		if (isValidSuit(suit)) {
			this.suit = suit;
		} else {
			System.out.println("ERROR: '" + Character.toString(suit) + "' is not a valid suit. Setting suit to 'X'.");
		}
		
		if (isValidValue(value)) {
			this.value = value;
		} else {
			System.out.println("ERROR: '" + value + "' is not a valid value. Setting value to 'X'.");
		}
	}
	
	/**
	 * Getter method for the card suit.
	 * @return the suit of the card as a char
	 */
	public char getSuit() {
		return suit;
	}
	
	/**
	 * Getter method for the card value.
	 * @return the value of the card as a String
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Setter method for the card suit.
	 * @param suit the new suit to set the card to
	 */
	public void setSuit(char suit) {
		if (isValidSuit(suit)) {
			this.suit = suit;
		} else {
			System.out.println("ERROR: '" + Character.toString(suit) + "' is not a valid suit. Making no changes.");
		}
	}
	
	/**
	 * Setter method for the card value.
	 * @param value the new value to set the card to
	 */
	public void setValue(String value) {
		if (isValidValue(value)) {
			this.value = value;
		} else {
			System.out.println("ERROR: '" + value + "' is not a valid value. Making no changes.");
		}
	}
	
	/**
	 * This function checks whether a character represents a valid suit.
	 * @param suitToCheck - the suit to check for validity
	 * @return boolean - true if valid, false otherwise
	 */
	private static boolean isValidSuit(char suitToCheck) {
		if (suitToCheck == 'C' || suitToCheck == 'D' || suitToCheck == 'H' || suitToCheck == 'S') {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This function checks whether a String represents a valid value.
	 * @param valueToCheck - the value to check for validity
	 * @return boolean - true if valid, false otherwise
	 */
	private static boolean isValidValue(String valueToCheck) {
		if (valueToCheck.matches("[2-9]|10|[AJQK]")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This function returns a String representation of the card.
	 * @return String - the String representation of the card
	 */
	@Override
	public String toString() {
		return suit + value;
	}
}
