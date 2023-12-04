
/**
 * The Account class represents a user account in the BlackJack game.
 * It stores the user's ID, role, and references to the Player and Dealer objects.
 */
public class Account {

	private String userID;
	private String role;
	Player player;
	Dealer dealer;

	/**
	 * Constructs an Account object with the specified username and role.
	 * If the role is "Player", a new Player object is created.
	 * If the role is "Dealer", a new Dealer object is created.
	 * 
	 * @param username the username of the account
	 * @param role     the role of the account ("Player" or "Dealer")
	 */
	public Account(String username) {
		this.userID = username;
		this.role = null;
	}

	/**
	 * Returns the username of the account.
	 * 
	 * @return the username of the account
	 */
	public String getUserID() {
		return this.userID;
	}

	/**
	 * Sets the role of the account.
	 * 
	 * @param r the role to be set ("Player" or "Dealer")
	 */
	public void setRole(String r) {
		this.role = r;
		if (this.role.equals("Player")) {
			this.player = new Player();
		} else if (this.role.equals("Dealer")) {
			this.dealer = new Dealer();
		}
	}

	/**
	 * Returns the role of the account.
	 * 
	 * @return the role of the account ("Player" or "Dealer")
	 */
	public String getRole() {
		return this.role;
	}

	/**
	 * Sets the username of the account.
	 * 
	 * @param id the username to be set
	 */
	public void setName(String id) {
		this.userID = id;
	}

	/**
	 * Returns the Player object associated with the account.
	 * 
	 * @return the Player object associated with the account
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * Returns the Dealer object associated with the account.
	 * 
	 * @return the Dealer object associated with the account
	 */
	public Dealer getDealer() {
		return this.dealer;
	}

	/**
	 * Sets the Player object associated with the account.
	 * 
	 * @param p the Player object to be set
	 */
	public void setPlayer(Player p) {
		this.player = p;
	}

	/**
	 * Sets the Dealer object associated with the account.
	 * 
	 * @param d the Dealer object to be set
	 */
	public void setDealer(Dealer d) {
		this.dealer = d;
	}

	/**
	 * Checks if the account has the role "Player".
	 * 
	 * @return true if the account has the role "Player", false otherwise
	 */
	public boolean isPlayer() {
		if (this.role.equals("Player")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if the account has the role "Dealer".
	 * 
	 * @return true if the account has the role "Dealer", false otherwise
	 */
	public boolean isDealer() {
		if (this.role.equals("Dealer")) {
			return true;
		} else {
			return false;
		}
	}
}