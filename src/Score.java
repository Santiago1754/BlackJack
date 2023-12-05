/**
 * Score class. Keeps track of the number of wins, losses, and funds won or
 * lost.
 */
public class Score {
    Account account;
    private int wins;
    private int losses;
    private int fundsWonOrLost;

    /**
     * Default constructor. Sets wins, losses, and fundsWonOrLost to 0.
     */
    public Score() {
        this.wins = 0;
        this.losses = 0;
        this.fundsWonOrLost = 0;
        this.account = null;
    }

    /**
     * Constructor. Sets wins, losses, and fundsWonOrLost to the given values.
     * 
     * @param wins
     * @param losses
     * @param fundsWonOrLost
     */
    public Score(Account account, int wins, int losses, int fundsWonOrLost) {
        this.account = account;
        this.wins = wins;
        this.losses = losses;
        this.fundsWonOrLost = fundsWonOrLost;
    }

    /**
     * Returns the number of wins.
     * 
     * @return wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Returns the number of losses.
     * 
     * @return losses
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Returns the funds won or lost.
     * 
     * @return fundsWonOrLost
     */
    public int getFundsWonOrLost() {
        return fundsWonOrLost;
    }

    /**
     * Adds 1 to the number of wins.
     */
    public void addWin() {
        this.wins++;
    }

    /**
     * Adds 1 to the number of losses.
     */
    public void addLoss() {
        this.losses++;
    }

    public Account getAccount() {
        return account;
    }

    /**
     * Adds the given value to the funds won or lost.
     * For positive values, the player won that amount.
     * For negative values, the player lost that amount.
     * 
     * @param fundsWonOrLost
     */
    public void addFundsWonOrLost(int fundsWonOrLost) {
        this.fundsWonOrLost += fundsWonOrLost;
    }

    /**
     * Returns a string representation of the Score object in the format:
     * Wins: <wins>
     * Losses: <losses>
     * Funds Won or Lost: <fundsWonOrLost>
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Wins: " + wins + "\nLosses: " + losses + "\nFunds Won or Lost: " + fundsWonOrLost;
    }
}
