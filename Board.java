// Tiancheng Dong (2471036)

public class Board {
	// Three attributes: number of rows, number of columns and a column object
	private int numRows;
	private int numCols;
	private Column[] cols;
	
	// A constructor with number of rows and columns
	public Board(int numRows, int numCols) {
		this.numRows = numRows;
		this.numCols = numCols;
		cols = new Column[numCols];
		for (int i = 0; i < numCols; i++) {
			cols[i] = new Column(numRows);
		}
	}
	
	// A boolean add method to check whether the counter is added
	public boolean add(Counter c, int colIndex) {
		return cols[colIndex].add(c);
	}
	
	// A method to produce a String representation of the board
	public String toString() {
		// An attribute of the board symbol
		String repr = "|";
		// Represent the head of ConnectFour
		for (int i = 0; i < numCols; i++) {
			repr += i + "|";
		}
		// Represent a line below the header
		repr += "\n-";
		for (int i = 0; i < numCols; i++) {
			repr += "--";
		}
		// Represent the main part of ConnectFour
		for (int i = 0; i < numRows; i++) {
			repr += "\n|";
			for (int j = 0; j < numCols; j++) {
				repr += cols[j].displayRow(i) + "|";
			}
		}
		return repr;
	}
	
	// A method to check whether the board is full
	public boolean isFull() {
		for (int i = 0; i < numCols; i++) {
			if (!cols[i].isFull()) {
				return false;
			}
		}
		return true;
	}
	
	// a method to check which player is the winner
	private boolean checkPostion(int row, int col) {
		// check whether there is a character on the position
        if (cols[col].displayRow(row).equals(" ")) {
            return false;
        }
        // an attribute of symbol
        String sym = cols[col].displayRow(row);

        // check column
        int start = row;
        int end = row;
        while (start >= 0 && cols[col].displayRow(start).equals(sym)) {
            start--;
        }

        while (end < numRows && cols[col].displayRow(end).equals(sym)) {
            end++;
        }

        if (end - start - 1 == 4) {
            return true;
        }

        // check row
        start = col;
        end = col;
        while (start >= 0 && cols[start].displayRow(row).equals(sym)) {
            start--;
        }

        while (end < numCols && cols[end].displayRow(row).equals(sym)) {
            end++;
        }

        if (end - start - 1 == 4) {
            return true;
        }

        // diag 1
        start = 0;
        end = 0;

        while (row+start >= 0 && col+start >= 0 && cols[col+start].displayRow(row+start).equals(sym)) {
            start--;
        }

        while (row+end < numRows && col+end < numCols && cols[col+end].displayRow(row+end).equals(sym)) {
            end++;
        }

        if (end - start - 1 == 4) {
            return true;
        }


        start = 0;
        end = 0;

        while (row+start >= 0 && col-start < numCols && cols[col-start].displayRow(row+start).equals(sym)) {
            start--;
        }

        while (row+end < numRows && col-end >= 0 && cols[col-end].displayRow(row+end).equals(sym)) {
            end++;
        }

        if (end - start - 1 == 4) {
            return true;
        }


        return false;
    }

	// get the winner player
    public Player checkWinner() {

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (checkPostion(i, j)) {
                    return cols[j].getRowPlayer(i);
                }
            }
        }
        return null;
    }
}
