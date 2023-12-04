
import java.util.Arrays;

/**
 * Represents a scoreboard for tracking player scores in a game.
 */
public class Scoreboard {

    private Score[] playerScores;

    /**
     * Constructs a scoreboard with initial player scores.
     *
     * @param playerScores The initial array of player scores.
     */
    public Scoreboard(Score[] playerScores) {
        this.playerScores = playerScores;
    }

    /**
     * Gets the score of a specific player.
     *
     * @param playerID The identifier of the player.
     * @return The score of the specified player.
     */
    public Score getPlayerScores(int playerID) {
        return playerScores[playerID];
    }

    /**
     * Sets the scores of all players in the scoreboard.
     *
     * @param playerScores The array of player scores.
     */
    public void setPlayerScores(Score[] playerScores) {
        this.playerScores = playerScores;
    }

    /**
     * Updates the scoreboard based on game events.
     * TODO: Add implementation details.
     */
    public void updateScoreboard() {
        // TODO: Implement scoreboard update logic
    }

    /**
     * Displays the current scoreboard.
     * TODO: Add implementation details.
     */
    public void displayScoreboard() {
        // TODO: Implement scoreboard display logic
    }

    /**
     * Adds a new player score to the scoreboard.
     *
     * @param score The score of the new player.
     */
    public void addPlayerScore(Score score) {
        Score[] newPlayerScores = Arrays.copyOf(playerScores, playerScores.length + 1);
        newPlayerScores[playerScores.length] = score;
        playerScores = newPlayerScores;
    }

    /**
     * Removes a player score from the scoreboard based on player ID.
     *
     * @param playerID The identifier of the player to be removed.
     */
    public void removePlayerScore(int playerID) {
        Score[] newPlayerScores = Arrays.stream(playerScores)
                .filter(score -> !score.getAccount().getUserID().equals(playerID))
                .toArray(Score[]::new);
        playerScores = newPlayerScores;
    }

    /**
     * Clears all player scores from the scoreboard.
     */
    public void clearScoreboard() {
        playerScores = new Score[0];
    }

    /**
     * Gets the number of players in the scoreboard.
     *
     * @return The number of players in the scoreboard.
     */
    public int getNumberOfPlayers() {
        return playerScores.length;
    }

    /**
     * Returns a string representation of the scoreboard.
     *
     * @return A string representation of the scoreboard.
     */
    public String toString() {
        return "Scoreboard{" + "playerScores=" + Arrays.toString(playerScores) + '}';
    }
}
