import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void testDefaultCard() {
        Card card = new Card();
        assertEquals('X', card.getSuit());
        assertEquals("X", card.getValue());
    }

    @Test
    public void testValidCard() {
        Card card = new Card('S', "A");
        assertEquals('S', card.getSuit());
        assertEquals("A", card.getValue());
    }

    @Test
    public void testInvalidCard() {
        Card card = new Card('Z', "Y");
        assertEquals('X', card.getSuit());
        assertEquals("X", card.getValue());
    }

    @Test
    public void testInvalidSuit() {
        Card card = new Card();
        card.setSuit('Z');
        assertEquals('X', card.getSuit());
    }

    @Test
    public void testInvalidValue() {
        Card card = new Card();
        card.setValue("Y");
        assertEquals("X", card.getValue());
    }

    @Test
    public void testValidSuit() {
        Card card = new Card();
        card.setSuit('S');
        assertEquals('S', card.getSuit());
    }

    @Test
    public void testValidValue() {
        Card card = new Card();
        card.setValue("A");
        assertEquals("A", card.getValue());
    }

    @Test
    public void testToString() {
        Card card = new Card('S', "A");
        assertEquals("SA", card.toString());
    }

    @Test
    public void testToStringDefault() {
        Card card = new Card();
        assertEquals("XX", card.toString());
    }

    @Test
    public void testEquals() {
        Card card1 = new Card('S', "A");
        Card card2 = new Card('S', "A");
        assertTrue(card1.equals(card2));
    }

    @Test
    public void testEqualsDefault() {
        Card card1 = new Card();
        Card card2 = new Card();
        assertTrue(card1.equals(card2));
    }

    @Test
    public void testEqualsNull() {
        Card card1 = new Card();
        Card card2 = null;
        assertFalse(card1.equals(card2));
    }

    @Test
    public void testEqualsDifferentClass() {
        Card card1 = new Card();
        String card2 = "Card";
        assertFalse(card1.equals(card2));
    }

    @Test
    public void testEqualsDifferentSuit() {
        Card card1 = new Card('S', "A");
        Card card2 = new Card('H', "A");
        assertFalse(card1.equals(card2));
    }

    @Test
    public void testEqualsDifferentValue() {
        Card card1 = new Card('S', "A");
        Card card2 = new Card('S', "K");
        assertFalse(card1.equals(card2));
    }

    @Test
    public void testEqualsDifferentSuitAndValue() {
        Card card1 = new Card('S', "A");
        Card card2 = new Card('H', "K");
        assertFalse(card1.equals(card2));
    }

    @Test
    public void testEqualsSameObject() {
        Card card1 = new Card('S', "A");
        assertTrue(card1.equals(card1));
    }
}
