import org.junit.Test;
import static org.junit.Assert.*;


public class DeckTest {
    @Test
    public void testDefaultDeck() {
        Deck deck = new Deck();
        assertEquals(52, deck.getCurrentDeckSize());
        assertEquals("52-C2,C3,C4,C5,C6,C7,C8,C9,C10,CA,CJ,CQ,CK,D2,D3,D4,D5,D6,D7,D8,D9,D10,DA,DJ,DQ,DK,H2,H3,H4,H5,H6,H7,H8,H9,H10,HA,HJ,HQ,HK,S2,S3,S4,S5,S6,S7,S8,S9,S10,SA,SJ,SQ,SK", deck.toString());
    }

    @Test
    public void testDeal() {
        Deck deck = new Deck();
        Card card = deck.deal();
        assertEquals(51, deck.getCurrentDeckSize());
        assertEquals("SK", card.toString());
    }

    @Test
    public void testDeal10() {
        Deck deck = new Deck();
        for (int i = 0; i < 10; i++) {
            deck.deal();
        }
        assertEquals(42, deck.getCurrentDeckSize());
        assertEquals("42-C2,C3,C4,C5,C6,C7,C8,C9,C10,CA,CJ,CQ,CK,D2,D3,D4,D5,D6,D7,D8,D9,D10,DA,DJ,DQ,DK,H2,H3,H4,H5,H6,H7,H8,H9,H10,HA,HJ,HQ,HK,S2,S3,S4", deck.toString());
    }
    
}