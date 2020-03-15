package com.Group12.Game;

public class GameMainForTest {



public static void main(String[] args) {
// TODO Auto-generated method stub
	new GameMainForTest().Run();
}


Board board;

public GameMainForTest() {
board = new Board();
}


public void Run() {
	while (true) {
		try {
			Thread.sleep(1000);
} 
		catch(Exception e) {

}

// make enemy move
	Enemy e = new Enemy(10,10, board);

	e.move();


	System.out.printf("%d %d\n", e.getX(), e.getY());


// display board
	this.printBoard();
	}
}


private void printBoard() {
	for(int y = 0; y < board.getYSize(); y++) {
		for (int x = 0; x < board.getYSize(); x++) {
			System.out.printf("%s ", board.getCellType(x, y));
		}
		System.out.println();
	}

	System.out.println("--------------");
}

