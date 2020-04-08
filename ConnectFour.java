// Tiancheng Dong (2471036)

import java.util.Random;

public class ConnectFour {
	public static void main(String[] args) {
		/*
		The following code is used to test whether player and counter are correctly created
		Player p1 = new Player( "Clive" , 'x' );
		Counter c = new Counter(p1);
		System.out.println(c.getPlayer().toString() + ", " +
		c.toString());
		
		
		The following code is used to test whether the column is correctly created
		Column col = new Column( 4 );
		for ( int i= 0 ;i< 5 ;i++) {
			boolean result = col.add( new Counter(p1));
			System.out.println(result);
		}
		
		
		The following code is used to test whether the column can be displayed correctly
		Column col = new Column( 6 );
		Player p1 = new Player( "Clive" , 'o' );
		Player p2 = new Player( "Sharon" , 'x' );
		for ( int i= 0 ;i< 3 ;i++) {
		col.add( new Counter(p1));
		col.add( new Counter(p2));
		}
		col.display();
		
		
		The following code is used to test whether the board can be displayed correctly
		Board board = new Board(6,7);
	    Player p1 = new Player("Clive",'o');
	    Player p2 = new Player("Sharon",'x');
	    board.add(new Counter(p2),6);
	    board.add(new Counter(p1),3);
	    board.add(new Counter(p2),4);
	    board.add(new Counter(p1),4);
	    board.add(new Counter(p2),5);
	    board.add(new Counter(p1),5);
	    board.add(new Counter(p2),6);
	    board.add(new Counter(p1),5);
	    board.add(new Counter(p2),6);
	    board.add(new Counter(p1),6);
	    System.out.println(board);
	    */
		
		// Call the randomPlay method
        randomPlay();
	}

	// a static method
	public static void randomPlay() {
		// Create a board object and two player objects
		Board board = new Board(6, 7);
		Player p1 = new Player("Clive",'o');
		Player p2 = new Player("Sharon",'x');
		
		// Play randomly
		Random rnd = new Random();
		Player p = p1;
		Player winner = null;
		// If a winner is found, stop the loop
		while ((winner = board.checkWinner()) == null) {
			while (true) {
				int colIndex = rnd.nextInt(7);
				if (board.add(new Counter(p), colIndex)) {
					p = p == p1 ? p2 : p1;
					break;
				}
			}
	            
		}
		// Display the board
		System.out.println(board);
		// Display the winner
		System.out.println("Winner: " + winner.toString());
	}
}
