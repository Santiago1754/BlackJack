/**
 * @author Santiago
 * @version 11/26/2023
 */
public class Game {
    private String id;
    private Player[] players;
    private int numPlayers;
    private Dealer dealer;
    private Scoreboard scoreboard;
    private Deck[] decks;

    /**
     * Constructs a Game object with the specified parameters.
     *
     * @param id         the ID of the game
     * @param players    an array of players participating in the game
     * @param dealer     the dealer of the game
     * @param scoreboard the scoreboard for tracking scores
     * @param decks      an array of decks used in the game
     */
    public Game(String id, Player[] players, Dealer dealer, Scoreboard scoreboard, Deck[] decks) {
        this.id = id;
        this.players = players;
        this.dealer = dealer;
        this.scoreboard = scoreboard;
        this.decks = decks;
        this.dealer = dealer;
    }

    /**
     * Checks if the game has a dealer.
     *
     * @return true if the game has a dealer, false otherwise
     */
    public boolean hasDealer() {
        if (dealer == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns the ID of the game.
     *
     * @return the ID of the game
     */
    public String getId() {
        return id;
    }

    /**
     * Returns an array of players participating in the game.
     *
     * @return an array of players
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Returns the dealer of the game.
     *
     * @return the dealer
     */
    public Dealer getDealer() {
        return dealer;
    }

    /**
     * Returns the scoreboard for tracking scores.
     *
     * @return the scoreboard
     */
    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    /**
     * Returns an array of decks used in the game.
     *
     * @return an array of decks
     */
    public Deck[] getDecks() {
        return decks;
    }

    /**
     * Sets the ID of the game.
     *
     * @param id the ID of the game
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the array of players participating in the game.
     *
     * @param players an array of players
     */
    public void setPlayers(Player[] players) {
        this.players = players;
    }

    /**
     * Sets the dealer of the game.
     *
     * @param dealer the dealer
     */
    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    /**
     * Sets the scoreboard for tracking scores.
     *
     * @param scoreboard the scoreboard
     */
    public void setScoreboard(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    /**
     * Sets the array of decks used in the game.
     *
     * @param decks an array of decks
     */
    public void setDecks(Deck[] decks) {
        this.decks = decks;
    }

    /**
     * Adds a player to the game.
     *
     * @param player the player to be added
     */
    public void addPlayer(Player player) {
        players[numPlayers] = player;
        numPlayers++;
    }

    /**
     * Returns number of players in the game.
     * 
     * @return number of players in the game
     */
    public int getNumPlayers() {
        return numPlayers;
    }

    /**
     * Starts the game.
     */
    public void startGame() {
        // TODO implement here
    }

    /**
     * Ends the game.
     */
    public void endGame() {
        // TODO implement here
    }

    /**
     * Returns a string representation of the Game object.
     *
     * @return a string representation of the Game object
     */
    public String toString() {
        return "Game: " + id + "\n" + "Players: " + players + "\n" + "Dealer: " + dealer + "\n" + "Scoreboard: "
                + scoreboard + "\n" + "Decks: " + decks;
    }
}