// Tiancheng Dong (2471036)

public class Counter {
	// one attribute: a reference to the player
	private Player player;
	
	// a constructor stores the attribute
	public Counter(Player player) {
		this.player = player;
	}
	// interpret player object as a String
	public String toString() {
		return "" + player.getSymbol();
	}
	
	// getter and setter for player
	public Player getPlayer() {
		return player;
	}
	public void setPlayer() {
		this.player = player;
	}
	
	// equals return true when it is passed another Player object
	public boolean equals(Counter other) {
		return player == other.getPlayer();
	}
}
