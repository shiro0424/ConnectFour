// Tiancheng Dong (2471036)

public class Player {
	// Two attributes: name and symbol
	private String name;
	private char symbol;
	
	// A constructor stores two attributes
	public Player(String name, char symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	
	// getters for name and symbol
	public String getName() {
		return name;
	}
	public char getSymbol() {
		return symbol;
	}
	
	// setters for name and symbol
	public void setName() {
		this.name = name;
	}
	public void setSymbol() {
		this.symbol = symbol;
	}
	
	// interpret name as a String
	public String toString() {
		return name;
	}
}
