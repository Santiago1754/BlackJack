import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreTest {
    @Test
    public void testGetWins() {
        Score score = new Score(null, 0, 0, 0);
        Assertions.assertEquals(0, score.getWins());
    }

    @Test
    public void testGetLosses() {
        Score score = new Score(null, 0, 0, 0);
        Assertions.assertEquals(0, score.getLosses());
    }

    @Test
    public void testGetFundsWonOrLost() {
        Score score = new Score(null, 0, 0, 0);
        Assertions.assertEquals(0, score.getFundsWonOrLost());
    }

    @Test
    public void testAddWin() {
        Score score = new Score(null, 0, 0, 0);
        score.addWin();
        Assertions.assertEquals(1, score.getWins());
    }

    @Test
    public void testAddLoss() {
        Score score = new Score(null, 0, 0, 0);
        score.addLoss();
        Assertions.assertEquals(1, score.getLosses());
    }

    @Test
    public void testAddFunds() {
        Score score = new Score(null, 0, 0, 0);
        score.addFundsWonOrLost(100);
        Assertions.assertEquals(100, score.getFundsWonOrLost());
    }

    @Test
    public void testSubtractFunds() {
        Score score = new Score(null, 0, 0, 0);
        score.addFundsWonOrLost(-100);
        Assertions.assertEquals(-100, score.getFundsWonOrLost());
    }

    @Test
    public void testToString() {
        Score score = new Score(null, 0, 0, 0);
        Assertions.assertEquals("Wins: 0\nLosses: 0\nFunds Won or Lost: 0", score.toString());
    }
}
