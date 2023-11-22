public class Scoreboard {
    private Score[] playerScores;

    public Scoreboard(Score[] playerScores) {
        this.playerScores = playerScores;
    }

    public Score getPlayerScores(int playerID) {
        return playerScores[playerID];
    }

    public void setPlayerScores(Score[] playerScores) {
        this.playerScores = playerScores;
    }

    public void updateScoreboard() {
        
    }

    public void displayScoreboard() {
        
    }

public void addPlayerScore(Score score) {
    // Add a new player score to the scoreboard
    Score[] newPlayerScores = new Score[playerScores.length + 1];
    for (int i = 0; i < playerScores.length; i++) {
        newPlayerScores[i] = playerScores[i];
    }
    newPlayerScores[playerScores.length] = score;
    playerScores = newPlayerScores;
}

public void removePlayerScore(int playerID) {
    // Remove a player score from the scoreboard based on player ID
    Score[] newPlayerScores = new Score[playerScores.length - 1];
    int index = 0;
    for (Score score : playerScores) {
        if (score.getPlayerID() != playerID) {
            newPlayerScores[index] = score;
            index++;
        }
    }
    playerScores = newPlayerScores;
}

public void clearScoreboard() {
    // Clear all player scores from the scoreboard
    playerScores = new Score[0];
}

public int getNumberOfPlayers() {
    return playerScores.length;
    // Return the number of players in the scoreboard
}

public String toString() {
        return "Scoreboard{" + "playerScores=" + Arrays.toString(playerScores) + '}';
    }

}