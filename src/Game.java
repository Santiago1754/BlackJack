public class Game {
    private String id;
    private Player[] players;
    private Dealer dealer;
    private Scoreboard scoreboard;
    private Deck[] decks;

    public Game(String id, Player[] players, Dealer dealer, Scoreboard scoreboard, Deck[] decks) {
        this.id = id;
        this.players = players;
        this.dealer = dealer;
        this.scoreboard = scoreboard;
        this.decks = decks;
        this.dealer = dealer;
    }

    public boolean hasDealer() {
        if (dealer == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getId() {
        return id;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public Deck[] getDecks() {
        return decks;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void setScoreboard(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    public void setDecks(Deck[] decks) {
        this.decks = decks;
    }

    public void startGame() {
        // TODO implement here
    }

    public void endGame() {
        // TODO implement here
    }

   public String toString() {
        return "Game: " + id + "\n" + "Players: " + players + "\n" + "Dealer: " + dealer + "\n" + "Scoreboard: " + scoreboard + "\n" + "Decks: " + decks;
    }
}