// Tiancheng Dong (2471036)

public class Column {
	// Three attributes
	private int numRows;
	private Counter[] counters;
	private boolean isFull;
	
	// Represent a column and check whether it is full
	public Column(int numRows) {
		this.numRows = numRows;
		// An array that stores Counter object
		counters = new Counter[numRows];
		// Loop for the column array
		for(int i = 0; i < numRows; i++) {
			counters[i] = null;
		}
		isFull = false;
	}
	
	// Add method
	public boolean add(Counter c) {
		// If the column is full, return false
		if(isFull) {
			return false;
		}
		// Attribute idx represents position which is numRows - 1
		int idx = 0;
		for(idx = numRows - 1; idx >= 0; idx--) {
			if(counters[idx] == null) {
				break;
			}
		}
		// If a counter is added, return true
		counters[idx] = c;
		if(idx == 0) {
			isFull = true;
		}
		return true;
	}
	
	// a displayRow method with a row number argument
	public String displayRow(int row) {
		/* If there is a counter on the position, return the character symbol
		Otherwise, return a space character */
		if(counters[row] != null) {
			return "" + counters[row].toString();
		} else {
			return " ";
		}
	}
	
	// getter for row player
	public Player getRowPlayer(int row) {
		if(counters[row] != null) {
			return counters[row].getPlayer();
		} else {
			return null;
		}
	}
	
	// a method used to display each row on a separate line
	public void display() {
		for(int i = 0; i < numRows; i++) {
			System.out.println(displayRow(i));
		}
	}
	public boolean isFull() {
		return isFull;
	}
}
